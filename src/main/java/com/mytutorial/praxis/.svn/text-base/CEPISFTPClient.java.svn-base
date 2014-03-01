package com.mytutorial.praxis;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class CEPISFTPClient {
	public static void main(String a[]) throws JSchException, SftpException {
		JSch jsch = new JSch();
		//jsch.setKnownHosts("PRAXIS/PRX8620.TST");

		Session session = jsch.getSession("ESRDIuser", "ets-scorelink.ets.org");
		session.setPassword("esrETS2011");
		java.util.Properties config = new java.util.Properties(); 
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();
		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp sftpChannel = (ChannelSftp) channel;
		sftpChannel.get("/Insts/FTP/private/edsasftp/PRAXIS/PRX8620.TST", "C:\\Users\\Keerthi\\Documents\\testfile");
		// OR
		//InputStream in = sftpChannel.get("/Insts/FTP/private/edsasftp/PRAXIS/PRX8620.TST");
		// process inputstream as needed
		sftpChannel.exit();
		session.disconnect();

	}
}
