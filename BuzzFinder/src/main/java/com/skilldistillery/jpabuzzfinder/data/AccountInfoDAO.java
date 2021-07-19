package com.skilldistillery.jpabuzzfinder.data;

import com.skilldistillery.jpabuzzfinder.entities.AccountInfo;
import com.skilldistillery.jpabuzzfinder.entities.User;

public interface AccountInfoDAO {
	AccountInfo findById(int id);
	AccountInfo update(int id, AccountInfo info);
	public boolean destroy(int id);
	AccountInfo create(AccountInfo info);
}
