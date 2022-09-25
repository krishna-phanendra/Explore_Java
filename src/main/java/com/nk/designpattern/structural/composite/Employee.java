package com.nk.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;

	private String id;

	private String salary;

	private List<Employee> subordinates;

	public Employee(String name, String id, String salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.subordinates = new ArrayList<Employee>();
	}

	public void add(Employee e) {
		this.getSubordinates().add(e);
	}

	public List<Employee> getSubordinateList() {
		return this.subordinates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + ", subordinates=" + subordinates + "]";
	}

}
