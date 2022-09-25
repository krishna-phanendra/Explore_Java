package com.nk.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
		sort(arr, 0, arr.length - 1);
	}

	public static void sort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = l + (r - 1) / 2;
			System.out
					.println(" l : " + l + ", r : " + r + ", mid : " + mid);
			sort(arr, l, mid);
//			System.out.println(
//					"Right values : " + Arrays.toString(arr) + ", mid : " + (mid + 1) + ", r : " + r + ", mid : " + mid);
			sort(arr, mid + 1, r);
//			merge(arr, l, mid, r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {

		int leftLength = m - l + 1;
		int rightLength = r - m;

		int[] leftArray = new int[leftLength];
		for (int i = 0; i < leftLength; i++)
			leftArray[i] = arr[i];

		int[] rightArray = new int[rightLength];
		for (int i = m; i < rightLength; i++)
			rightArray[i] = arr[i];

		System.out
				.println("left tree : " + Arrays.toString(leftArray) + ", right tree : " + Arrays.toString(rightArray));

	}

}
