package com.nk.techgig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Challenge1 {

	public static void main(String[] args) {
//		System.out.println("args : " + Arrays.toString(args));
//		int noOfTestCases = Integer.valueOf(args[0]);
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		if (noOfTestCases > 0) {
			for (int t = 0; t < noOfTestCases; t++) {
				int noOfObjects = sc.nextInt();
//				System.out.println("noOfObjects : "+noOfObjects);
//				System.out.println("value : "+args[i]);
				List<Integer> inputArr = new ArrayList<>();
				for (int v = 0; v < noOfObjects; v++)
					inputArr.add(sc.nextInt());
				
				System.out.println("array : "+inputArr);

				Map<Integer, Long> splitMap = new HashMap<>();

				Long noOfPairs = 0L;
				for (int j = 0; j < inputArr.size(); j++) {
					Long counter = splitMap.get(inputArr.get(j));
					counter = (counter == null)? 1L : counter + 1;
					splitMap.put(inputArr.get(j), counter);
				
					
					if (counter % 2 == 0) {
						noOfPairs = noOfPairs + counter;
					}					
				}
//				System.out.println("splitMap : "+splitMap);
//				Collection<Integer> values = splitMap.values();
//				for (Integer val : values) {
//					if (val % 2 == 0) {
//						noOfPairs = noOfPairs + val;
//					}
//				}

				System.out.println(noOfPairs);
			}
		}
	}
}
