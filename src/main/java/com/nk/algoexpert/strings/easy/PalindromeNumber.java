package com.nk.algoexpert.strings.easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println("--->" + isPalindrome(120121));
	}

	/**
	 * Runtime: 6 ms, Memory Usage: 38.5 MB
	 * 
	 * @param x
	 * @return
	 */
	private static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;

		int y = 0;
		while (x > y) {
			System.out.println("mod : "+ (x%10));
			y = (y * 10) + (x % 10);
			x = x / 10;
			System.out.println(x + "---" + y);
		}

		if (x == y || y / 10 == x)
			return true;

		return false;
	}

	/**
	 * Runtime: 7 ms, Memory Usage: 38.5 MB
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isPalindromeCheckWithStringConvertion(int value) {
		String val = String.valueOf(value);
		System.out.println("mod : " + val.length() / 2);
		for (int i = 0; i < val.length() / 2; i++) {
			System.out.println(val.charAt(i) + "------" + val.charAt((val.length() - i) - 1));
			if (val.charAt(i) != val.charAt((val.length() - i) - 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Runtime: 10 ms, Memory Usage: 38.9 MB
	 * 
	 * @param x
	 * @return
	 */
	private static boolean isPalindromeWithStrBuilder(int x) {
		StringBuilder sbr = new StringBuilder(String.valueOf(x));
		StringBuilder reverse = sbr.reverse();
		String val = String.valueOf(x);
		if (val.equals(reverse.toString()))
			return true;

		return false;
	}

}
