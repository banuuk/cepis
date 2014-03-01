/**
 * 
 */
package edu.uky.cepis.util.operations;

import java.io.Serializable;

/**
 * @author keerthi
 * 
 */
public class StringOperation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String replaceWSByString(String sourceStr, String replacement) {
		if (sourceStr == null) {
			return null;
		}
		if (replacement == null) {
			return sourceStr;
		}
		String destStr = sourceStr.trim();
		destStr = destStr.replaceAll("\\s+", replacement);
		return destStr;
	}

	public static String[] formatStringQuery(String sourceStr) {
		if (sourceStr == null) {
			return null;
		}

		return sourceStr.trim().split("\\s+");

	}

	public static String appendStartEndWithString(String sourceStr) {
		if (sourceStr == null) {
			return null;
		}

		String appendStr = ".*";

		StringBuffer destStr = new StringBuffer();
		destStr.append(appendStr);
		destStr.append(sourceStr.trim());
		destStr.append(appendStr);

		return destStr.toString();
	}

	public static String getConcatOperationString(boolean concat) {
		return concat ? "|" : ".*";
	}

	public static void main(String[] a) {
		String[] test = StringOperation
				.formatStringQuery("keerthi ram   muruge  san");
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]+"!!");
		}
	}

}
