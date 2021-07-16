package com.skilldistillery.jpabuzzfinder.data;

import com.skilldistillery.jpabuzzfinder.entities.User;

public interface UserDAO {
	
	User findById(int id);
}
