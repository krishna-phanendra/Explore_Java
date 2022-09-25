package com.nk.algoexpert.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSubsequence {

	public static void main(String[] args) {

		List<Integer> mainarr = new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
		List<Integer> subarr = new ArrayList<>(Arrays.asList(5, 1, 22, 6, 10));

		boolean execute = execute(mainarr, subarr);
		System.out.println("execute 1: " + execute);

		mainarr = new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
		subarr = new ArrayList<>(Arrays.asList(22, 25, 6));
		execute = execute(mainarr, subarr);
		System.out.println("execute 2: " + execute);

	}

	/**
	 * TimeComplexity: O(n), Memory Usage: 39.3 MB
	 * 
	 * @param mainarr
	 * @param subarr
	 * @return
	 */
	private static boolean execute(List<Integer> mainarr, List<Integer> subarr) {
		int j = 0;
		for (int i = 0; i < mainarr.size(); i++) {
			if (j < subarr.size() && (mainarr.get(i) == subarr.get(j)))
				j++;
		}
		return j == subarr.size();
	}
}
