package com.nk.functionalinterface.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ListToMap {

	public static void main(String[] args) {

		ListToMap obj = new ListToMap();

		List<String> types = Arrays.asList("private", "public", "protected", "default");

		Map<String, Integer> map = obj.covertToMap(types, x -> x.length());

		System.out.println("Map : " + map);

	}

	public <T, R> Map<T, R> covertToMap(List<T> list, Function<T, R> func) {

		Map<T, R> map = new HashMap<T, R>();
		for (T item : list) {
			map.put(item, func.apply(item));
		}
		return map;
	}

}
