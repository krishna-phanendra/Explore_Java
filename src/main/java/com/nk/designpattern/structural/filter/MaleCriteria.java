package com.nk.designpattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class MaleCriteria implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> list = new ArrayList<>();
		for (Person person : persons) {
			if (person.getGender().equalsIgnoreCase("Male"))
				list.add(person);
		}
		return list;
	}

}
