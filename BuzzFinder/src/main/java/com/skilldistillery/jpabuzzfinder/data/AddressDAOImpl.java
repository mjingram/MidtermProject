package com.skilldistillery.jpabuzzfinder.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpabuzzfinder.entities.Address;

@Service
@Transactional
public class AddressDAOImpl implements AddressDAO{
	
	@PersistenceContext
	private EntityManager em;
///////////// Find Address By Id ////////////////	
	@Override
	public Address findAddressById(int id) {
		return em.find(Address.class, 1);
	}
///////////// Create Address  //////////////////
	@Override
	public Address createAddress(Address addr) {
		em.persist(addr);
		return addr;
	}
///////////// Remove an Address ////////////////
	public boolean removeAddress(int id) {
		boolean check = false;
		Address addr = em.find(Address.class, id);
		if (addr != null) {
			em.remove(addr);
			return true;
			
		}
		return check;
	}
///////////// Update an Address ////////////////
	@Override
	public Address updateAddress(Integer id, Address addr) {
		Address mAddr = em.find(Address.class, id);
		mAddr.setStreet(addr.getStreet());
		mAddr.setCity(addr.getCity());
		mAddr.setState(addr.getState());
		mAddr.setZipcode(addr.getZipcode());
		System.out.println(mAddr);
		return mAddr;
	}
}
