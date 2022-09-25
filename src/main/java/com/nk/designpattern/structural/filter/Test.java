package com.nk.designpattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Person p1 = new Person("A", "Male", "Single");
		Person p2 = new Person("B", "Female", "Single");
		Person p3 = new Person("C", "Male", "Married");
		Person p4 = new Person("D", "Male", "Single");
		Person p5 = new Person("E", "Female", "Married");
		List<Person> ppl = new ArrayList<Person>();
		ppl.add(p1);
		ppl.add(p2);
		ppl.add(p3);
		ppl.add(p4);
		ppl.add(p5);

		Criteria mc = new MaleCriteria();
		List<Person> maleList = mc.meetCriteria(ppl);
		System.out.println("Male : " + maleList);

		Criteria mc1 = new MarriedCriteria();
		List<Person> marriedList = mc1.meetCriteria(ppl);
		System.out.println("Married List : " + marriedList);

		Criteria andC = new AndCriteria(mc, mc1);
		List<Person> andList = andC.meetCriteria(ppl);
		System.out.println("Male and Married List : " + andList);

		/**
		 * using Lambda expressions
		 */
		Criteria sc = (ppl1) -> {
			List<Person> filterList = new ArrayList<Person>();
			for (Person p : ppl1) {
				if (p.getMaritalStatus().equalsIgnoreCase("Single"))
					filterList.add(p);
			}
			return filterList;
		};

		List<Person> c = sc.meetCriteria(ppl);
		System.out.println("c :: " + c);
	}

}
