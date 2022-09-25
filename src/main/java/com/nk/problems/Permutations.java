package com.nk.problems;

public class Permutations {

	// Function to print all the permutations of str
	static void printPermutn(String str, String ans, int iteration) {
		System.out.println("iteration : " + iteration);
		// If string is empty
		if (str.length() == 0) {
			System.out.println(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			System.out.println("-----------" + i);
			// ith character of str
			char ch = str.charAt(i);
			System.out.println("ch : " + ch);
			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) + str.substring(i + 1);
			System.out.println("ros : " + ros);
			// Recurvise call
			printPermutn(ros, ans + ch, i);
		}
	}

	// Driver code
	public static void main(String[] args) {
		String s = "abc";
		printPermutn(s, "", 0);
	}

}
