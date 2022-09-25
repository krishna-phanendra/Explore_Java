package com.nk.algoexpert.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {
	public static void main(String[] args) {
		int inputarr[] = { 4, 4, 1, 8 };
		int[] sum = sum(inputarr, 9);
		System.out.println("set : " + Arrays.toString(sum));

	}

	/**
	 * Runtime: 1 ms, Memory Usage: 39.3 MB
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int[] sum(int[] nums, int target) {
		Map<Integer, Integer> ht = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int compliment = target - nums[i];
			if (ht.containsKey(compliment))
				return new int[] {ht.get(compliment), i  };			
			ht.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution");
	}

}
