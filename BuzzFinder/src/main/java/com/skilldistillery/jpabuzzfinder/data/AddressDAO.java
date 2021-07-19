package com.skilldistillery.jpabuzzfinder.data;

import com.skilldistillery.jpabuzzfinder.entities.Address;

public interface AddressDAO {
	
Address findAddressById(int id);
Address createAddress(Address addr);
Address updateAddress(Integer id, Address addr);
boolean removeAddress(int id);
}
