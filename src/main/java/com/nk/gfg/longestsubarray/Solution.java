package com.nk.gfg.longestsubarray;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {

		ArrayList<Integer> output = null;
//		int[] A = { 1, 2, 3, 7, 5 };
		int N = 5, S = 12;
//		output = subarraySum(A, N, S);
//		System.out.println("output : " + output);

		N = 10;
		S = 15;
//		int[] A2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		output = subarraySum(A2, N, S);
//		System.out.println("output : " + output);

		N = 42;
		S = 468;
		int[] A3 = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
				154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 };
		output = subarraySum(A3, N, S);
		System.out.println("output : " + output);

		sum(23, 33, A3);

	}

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		ArrayList<Integer> outputList = new ArrayList<>();
		int startIndex = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {

			if (sum < s) {
				System.out.println(i + ", " + startIndex + ",  " + sum + "+" + arr[i] + " = " + (sum + arr[i]));
				sum = sum + arr[i];
				if (sum > s) {
					System.out.println("sub =   " + sum + "-" + arr[startIndex] + " = " + (sum - arr[startIndex]));
					sum = sum - arr[startIndex];
					startIndex++;
				}
			} else if (sum > s) {
				System.out.println("sub1 =   " + sum + "-" + arr[startIndex] + " = " + (sum - arr[startIndex]));
				sum = sum - arr[startIndex];
				startIndex++;
				continue;
			}

			System.out.println("sum : " + sum);
			if (sum == s) {
				outputList.add(startIndex + 1);
				outputList.add(i + 1);
				break;
			}
		}

		return outputList;
	}

	private static void sum(int i, int j, int[] a) {
		int sum = 0;
		for (int k = i - 1; k < j; k++) {
			sum = sum + a[k];
		}
		System.out.println("sum : " + sum);

	}
}
