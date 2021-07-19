package com.skilldistillery.jpabuzzfinder.data;

import com.skilldistillery.jpabuzzfinder.entities.User;

public interface UserDAO {
	
	public User create(User user);
//	public User updateById(int id, User user);
	public User updateUsernameAndPassword(String password, User user);
	public boolean destroyById(int id);
	public User findById(int id);
	public User findByUsername(String username, String password);
	
}

