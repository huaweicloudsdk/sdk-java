package com.huawei.openstack4j.utils;

import java.util.Locale;

/**
 * Utilities for encoding and decoding binary data to and from different forms.
 */
public class BinaryUtils {

	/**
	 * Converts byte data to a Hex-encoded string.
	 *
	 * @param data
	 *            data to hex encode.
	 *
	 * @return hex-encoded string.
	 */
	public static String toHex(byte[] data) {
		StringBuilder sb = new StringBuilder(data.length * 2);
		for (int i = 0; i < data.length; i++) {
			String hex = Integer.toHexString(data[i]);
			if (hex.length() == 1) {
				// Append leading zero.
				sb.append("0");
			} else if (hex.length() == 8) {
				// Remove ff prefix from negative numbers.
				hex = hex.substring(6);
			}
			sb.append(hex);
		}
		return sb.toString().toLowerCase(Locale.getDefault());
	}

	
}
