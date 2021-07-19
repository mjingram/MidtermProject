package com.skilldistillery.jpabuzzfinder.data;

import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.User;

public interface UserDAO {
	
	public User create(User user);
//	public User updateById(int id, User user);
	public User updateUsernameAndPassword(String password, User user);
	public boolean destroyByUsername(String username, String password);
//	public User findById(int id);
	public User login(String username, String password);
	public Beer addFavBeer(User user, Beer beer); 
	
}

