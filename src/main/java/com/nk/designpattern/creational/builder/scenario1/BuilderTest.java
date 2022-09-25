package com.nk.designpattern.creational.builder.scenario1;

import java.util.HashMap;
import java.util.Map;

public class BuilderTest {

	public static void main(String[] args) {

		String jsonPath = "a1.b1.c1";
		Object val = 4;

		Map<String, Object> jsonObject = new HashMap<String, Object>() {
			{
				Map<String, Object> b1obj = new HashMap<String, Object>() {
					{
						put("b1", 1);
					}
				};
				Map<String, Object> b2obj = new HashMap<String, Object>() {
					{
						put("b2", 2);
					}
				};
				put("a1", b1obj);
				put("a2", b2obj);
				put("a3", 3);
			}
		};

		System.out.println(jsonObject);

		setValue(jsonObject, "a2.b2", 4);
		setValue(jsonObject, "a2.b3", 5);
		setValue(jsonObject, "a3.b4", 6);
		setValue(jsonObject, "a4", 7);

		System.out.println(jsonObject);

	}

	@SuppressWarnings(value = { "" })
	public static void setValue(Map<String, Object> jsonObject, String jsonPath, Object val) {
		String firstNode = jsonPath.split("\\.")[0];
		System.out.println(jsonPath + " firstnode : " + firstNode);
		if (jsonObject != null) {
			if (jsonObject.containsKey(firstNode)) {
				String subPath = jsonPath.substring(jsonPath.indexOf(".") + 1);
				System.out.println(subPath + " subPath : ");
				Object mapValue = jsonObject.get(firstNode);
				if (mapValue instanceof Map) {
					Map<String, Object> valObject = (Map<String, Object>) mapValue;
					if (subPath.contains(".")) {
						setValue(valObject, subPath, valObject);
					} else {
						valObject.put(subPath, val);
					}
				} else {
					System.out.println("subpath : "+subPath);
					Map<String, Object> newMap = new HashMap<String, Object>();
					jsonObject.put(firstNode, newMap);
					if (subPath.contains("."))
						setValue(newMap, subPath, val);
					else
						newMap.put(subPath, val);
				}

			} else {
				jsonObject.put(firstNode, val);
			}
		}
	}
}
