package com.ymsli.mvc.model.service;

import java.util.Optional;

import com.ymsli.mvc.model.persistance.user.User;

public interface UserService {
	public void addUser(User user);
	public Optional<User> getUser(String username, String password);	
}
