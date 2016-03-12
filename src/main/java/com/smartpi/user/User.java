package com.smartpi.user;

public class User {
	String id;
	String firstName;
	String lastName;
	String email;
	int age;

	public User(final String firstName, final String lastName,
			final String email, final int age) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = "3";
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}
}