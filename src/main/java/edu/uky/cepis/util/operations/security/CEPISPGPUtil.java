package edu.uky.cepis.util.operations.security;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import java.util.Iterator;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyEncryptedData;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;

/**
 * Simple routine to encrypt and decrypt using a Public and Private key with
 * passphrase. This service routine provides the basic PGP services between byte
 * arrays.
 * 
 */
public class CEPISPGPUtil {

	private static PGPPrivateKey findSecretKey(
			PGPSecretKeyRingCollection pgpSec, long keyID, char[] pass)
			throws PGPException, NoSuchProviderException {
		PGPSecretKey pgpSecKey = pgpSec.getSecretKey(keyID);

		if (pgpSecKey == null) {
			return null;
		}

		return pgpSecKey.extractPrivateKey(pass, "BC");
	}

	/**
	 * decrypt the passed in message stream
	 * 
	 * @param encrypted
	 *            The message to be decrypted.
	 * @param passPhrase
	 *            Pass phrase (key)
	 * 
	 * @return Clear text as a byte array. I18N considerations are not handled
	 *         by this routine
	 * @exception IOException
	 * @exception PGPException
	 * @exception NoSuchProviderException
	 */
	public static byte[] decrypt(byte[] encrypted, InputStream keyIn,
			char[] password) throws IOException, PGPException,
			NoSuchProviderException {
		InputStream in = new ByteArrayInputStream(encrypted);

		in = PGPUtil.getDecoderStream(in);

		PGPObjectFactory pgpF = new PGPObjectFactory(in);
		PGPEncryptedDataList enc = null;
		Object o = pgpF.nextObject();

		//
		// the first object might be a PGP marker packet.
		//
		if (o instanceof PGPEncryptedDataList) {
			enc = (PGPEncryptedDataList) o;
		} else {
			enc = (PGPEncryptedDataList) pgpF.nextObject();
		}

		//
		// find the secret key
		//
		Iterator it = enc.getEncryptedDataObjects();
		PGPPrivateKey sKey = null;
		PGPPublicKeyEncryptedData pbe = null;
		PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(
				PGPUtil.getDecoderStream(keyIn));

		while (sKey == null && it.hasNext()) {
			pbe = (PGPPublicKeyEncryptedData) it.next();

			sKey = findSecretKey(pgpSec, pbe.getKeyID(), password);
		}

		if (sKey == null) {
			throw new IllegalArgumentException(
					"secret key for message not found.");
		}

		InputStream clear = pbe.getDataStream(sKey, "BC");

		PGPObjectFactory pgpFact = new PGPObjectFactory(clear);

		PGPCompressedData cData = (PGPCompressedData) pgpFact.nextObject();

		pgpFact = new PGPObjectFactory(cData.getDataStream());

		PGPLiteralData ld = (PGPLiteralData) pgpFact.nextObject();

		InputStream unc = ld.getInputStream();

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int ch;

		while ((ch = unc.read()) >= 0) {
			out.write(ch);

		}

		byte[] returnBytes = out.toByteArray();
		out.close();
		return returnBytes;
	}

	/**
	 * Simple PGP encryptor between byte[].
	 * 
	 * @param clearData
	 *            The test to be encrypted
	 * @param passPhrase
	 *            The pass phrase (key). This method assumes that the key is a
	 *            simple pass phrase, and does not yet support RSA or more
	 *            sophisiticated keying.
	 * @param fileName
	 *            File name. This is used in the Literal Data Packet (tag 11)
	 *            which is really inly important if the data is to be related to
	 *            a file to be recovered later. Because this routine does not
	 *            know the source of the information, the caller can set
	 *            something here for file name use that will be carried. If this
	 *            routine is being used to encrypt SOAP MIME bodies, for
	 *            example, use the file name from the MIME type, if applicable.
	 *            Or anything else appropriate.
	 * 
	 * @param armor
	 * 
	 * @return encrypted data.
	 * @exception IOException
	 * @exception PGPException
	 * @exception NoSuchProviderException
	 */
	public static byte[] encrypt(byte[] clearData, PGPPublicKey encKey,
			String fileName, boolean withIntegrityCheck, boolean armor)
			throws IOException, PGPException, NoSuchProviderException {
		if (fileName == null) {
			fileName = PGPLiteralData.CONSOLE;
		}

		ByteArrayOutputStream encOut = new ByteArrayOutputStream();

		OutputStream out = encOut;
		if (armor) {
			out = new ArmoredOutputStream(out);
		}

		ByteArrayOutputStream bOut = new ByteArrayOutputStream();

		PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(
				PGPCompressedDataGenerator.ZIP);
		OutputStream cos = comData.open(bOut); // open it with the final
		// destination
		PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();

		// we want to generate compressed data. This might be a user option
		// later,
		// in which case we would pass in bOut.
		OutputStream pOut = lData.open(cos, // the compressed output stream
				PGPLiteralData.BINARY, fileName, // "filename" to store
				clearData.length, // length of clear data
				new Date() // current time
				);
		pOut.write(clearData);

		lData.close();
		comData.close();

		PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(
				PGPEncryptedData.CAST5, withIntegrityCheck, new SecureRandom(),
				"BC");

		cPk.addMethod(encKey);

		byte[] bytes = bOut.toByteArray();

		OutputStream cOut = cPk.open(out, bytes.length);

		cOut.write(bytes); // obtain the actual bytes from the compressed stream

		cOut.close();

		out.close();

		return encOut.toByteArray();
	}

	private static PGPPublicKey readPublicKey(InputStream in)
			throws IOException, PGPException {
		in = PGPUtil.getDecoderStream(in);

		PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(in);

		//
		// we just loop through the collection till we find a key suitable for
		// encryption, in the real
		// world you would probably want to be a bit smarter about this.
		//

		//
		// iterate through the key rings.
		//
		Iterator rIt = pgpPub.getKeyRings();

		while (rIt.hasNext()) {
			PGPPublicKeyRing kRing = (PGPPublicKeyRing) rIt.next();
			Iterator kIt = kRing.getPublicKeys();

			while (kIt.hasNext()) {
				PGPPublicKey k = (PGPPublicKey) kIt.next();

				if (k.isEncryptionKey()) {
					return k;
				}
			}
		}

		throw new IllegalArgumentException(
				"Can't find encryption key in key ring.");
	}

	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		// Get the size of the file
		long length = file.length();

		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		// Close the input stream and return bytes
		is.close();
		return bytes;
	}

	public static void main(String[] args) throws Exception {
		Security.addProvider(new BouncyCastleProvider());

		/*
		 * byte[] original = "Hello world".getBytes();
		 * System.out.println("Starting PGP test");
		 * 
		 * FileInputStream pubKey = new FileInputStream("/Users/me/pub.key");
		 * byte[] encrypted = encrypt(original, readPublicKey(pubKey), null,
		 * true, true);
		 * 
		 * FileOutputStream dfis = new FileOutputStream("/Users/me/enc.asc");
		 * dfis.write(encrypted); dfis.close();
		 */
		System.out
				.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Encrypted File>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		File encryptedFile = new File(
				"C:\\Workspace\\cepis\\src\\main\\java\\edu\\uky\\cepis\\util\\operations\\security\\PRX1837.pgp");

		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(encryptedFile));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out
				.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Decrypted Content>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		byte[] encFromFile = getBytesFromFile(encryptedFile);
		FileInputStream secKey = new FileInputStream(
				"C:\\Workspace\\cepis\\src\\main\\java\\edu\\uky\\cepis\\util\\operations\\security\\etsukscorelink-private.asc");

		byte[] decrypted = decrypt(encFromFile, secKey,
				"s@int007_ed".toCharArray());

		System.out.println(new String(decrypted));
		System.out
				.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Encrypt again to test>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		FileInputStream pubKey = new FileInputStream(
				"C:\\Workspace\\cepis\\src\\main\\java\\edu\\uky\\cepis\\util\\operations\\security\\etsukscorelink-public.asc");
		byte[] encrypted = encrypt(decrypted, readPublicKey(pubKey), null,
				true, true);
		System.out.println(new String(encrypted));
		System.out
				.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Decrypt again to test>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		secKey = new FileInputStream(
				"C:\\Workspace\\cepis\\src\\main\\java\\edu\\uky\\cepis\\util\\operations\\security\\etsukscorelink-private.asc");
		decrypted = decrypt(encrypted, secKey, "s@int007_ed".toCharArray());
		System.out.println(new String(decrypted));
		// FileOutputStream dfis = new FileOutputStream("/Users/me/enc.asc");
		// dfis.write(encrypted);
		// dfis.close();

	}

	public static String getMD5Hash(String text) {
		MessageDigest messageDigest;
		String hashedPass = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.update(text.getBytes(), 0, text.length());
			hashedPass = new BigInteger(1, messageDigest.digest()).toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;
			}
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		}
		return hashedPass;
	}

}