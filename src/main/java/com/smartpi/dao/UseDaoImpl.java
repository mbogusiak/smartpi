package com.smartpi.dao;

import org.springframework.stereotype.Repository;

import com.smartpi.user.User;

@Repository
public class UseDaoImpl implements UserDao {

	public User getUserById(final String id) {
		System.out.println("ID " + id);
		final User user = new User("Marcin", "Bogusiak", "mbogusiak@gmail.com",
				30);
		return user;
	}
}
