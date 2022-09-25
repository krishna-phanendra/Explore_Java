package com.nk.json;

import java.util.Arrays;

import com.google.gson.annotations.JsonAdapter;

public class Employee {

	private String name;

	private int age;

//	@JsonAdapter(ArrayAdapter.class)
	private Location[] location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Location[] getLocation() {
		return location;
	}

	public void setLocation(Location[] location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", location=" + Arrays.toString(location) + "]";
	}

}
