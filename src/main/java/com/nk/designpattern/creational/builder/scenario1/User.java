package com.nk.designpattern.creational.builder.scenario1;

public class User {

	private final String firstName;

	private final String lastName;

	private final int age;

	private final String address;

	private final long phone;

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.address = builder.address;
		this.phone = builder.phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public long getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ ", phone=" + phone + "]";
	}

	public static class UserBuilder {

		private final String firstName;

		private final String lastName;

		private int age;

		private String address;

		private long phone;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		public UserBuilder phone(long phone) {
			this.phone = phone;
			return this;
		}

		public User build() {
			User user = new User(this);
			return user;
		}
	}
}
