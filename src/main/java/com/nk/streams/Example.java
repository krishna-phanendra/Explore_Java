package com.nk.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// using map
		List<Integer> square = list.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println("square : " + square);
		System.out.println("original list : " + list);

		List<String> nameList = Arrays.asList("Arrays", "Reflection", "Streams");

		// using filter
		List<String> nameResult = nameList.stream().filter(x -> x.startsWith("S")).collect(Collectors.toList());
		System.out.println("nameResult : " + nameResult);

		List<Integer> unsortedlist = Arrays.asList(3, 5, 3, 1, 7, 9);

		// using sorted
		List<Integer> sortedList = unsortedlist.stream().sorted().collect(Collectors.toList());
		System.out.println("sortedList : " + sortedList);

		// create a list of integers
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);
		// using collect to return set
		Set<Integer> set = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
		System.out.println("set : " + set);

		// using forEach
		numbers.forEach(x -> System.out.print(x * x + " "));

		// using reduce
		int even = numbers.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
		System.out.println("even : " + even);

	}

}
