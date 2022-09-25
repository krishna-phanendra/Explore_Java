package com.nk.designpattern.structural.composite;

public class Test {

	public static void main(String[] args) {
		Employee e = new Employee("n1", "id1", "25L");
		Employee s1 = new Employee("s1", "id_s_1", "15L");
		Employee s2 = new Employee("s2", "id_s_2", "5L");
		Employee s3 = new Employee("s3", "id_s_3", "17L");

		e.add(s1);
		e.add(s2);
		s2.add(s3);
		System.out.println("CEO : " + e);

		for (Employee list : e.getSubordinates()) {
			System.out.println("list : " + list);
			for (Employee emp : list.getSubordinates())
				System.out.println("e : " + emp);
		}
	}

}
