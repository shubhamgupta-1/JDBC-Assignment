package com.ymsli.mvc.model.service;

import java.util.Optional;

import com.ymsli.mvc.model.persistance.user.User;
import com.ymsli.mvc.model.persistance.user.UserDao;
import com.ymsli.mvc.model.persistance.user.UserDaoImpl;

public class UserServiceImpl implements UserService{
	UserDao userDao;
	public UserServiceImpl(){
		userDao=new UserDaoImpl();
	}
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public Optional<User> getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

}
