package com.nk.functionalinterface.bifunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Example2 {

	public static void main(String[] args) {

		Example2 exp = new Example2();

		List<String> list = Arrays.asList("java", "python", "c++", "javascript");

		List<String> filterList = exp.filterList(list, 3, exp::filterBySize);
		System.out.println("filterlist : " + filterList);

		List<String> result11 = exp.filterList(list, 5, (l1, size) -> {
			if (l1.length() > size)
				return l1;
			return null;
		});
		System.out.println("filterlist : " + result11);
	}

	public String filterBySize(String str, int size) {
		if (str.length() > size)
			return str;
		return null;
	}

	public <T, U, R> List<R> filterList(List<T> list, U size, BiFunction<T, U, R> func) {
		List<R> updatedList = new ArrayList<>();
		for (T item : list) {
			R apply = func.apply(item, size);
			if (apply != null)
				updatedList.add(apply);
		}

		return updatedList;
	}
}
