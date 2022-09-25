package com.nk.designpattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class MarriedCriteria implements Criteria {

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> list = new ArrayList<>();
		for (Person person : persons) {
			if (person.getMaritalStatus().equalsIgnoreCase("Married"))
				list.add(person);
		}
		return list;
	}

}
