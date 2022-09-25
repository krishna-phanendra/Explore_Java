package com.nk.algoexpert.strings;

public class DefangingIPAddress {

	public static void main(String[] args) {
		
		System.out.println("====="+executeStrReplace("125.215.145.254"));

	}
	
	/**
	 * Runtime: 0 ms, Memory 36.8 MB
	 * @param ip4address
	 * @return
	 */
	private static String executeStrReplace(String ip4address) {
		String[] split = ip4address.split("\\.");
		if (split == null || split.length != 4)
			throw new IllegalArgumentException(ip4address);

		return ip4address.replace(".", "[.]");
	}

	/**
	 * Runtime: 1 ms, Memory 37.8 MB
	 * @param ip4address
	 * @return
	 */
	private static String execute(String ip4address) {
		String[] split = ip4address.split("\\.");
		if (split == null || split.length != 4)
			throw new IllegalArgumentException(ip4address);

		StringBuilder sbr = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			if (Integer.valueOf(split[i]) >= 0 && Integer.valueOf(split[i]) <= 255) {
				sbr.append(split[i]);
				if (i != 3)
					sbr.append("[.]");
			} else
				throw new IllegalArgumentException(ip4address);
		}

		return sbr.toString();
	}

}
