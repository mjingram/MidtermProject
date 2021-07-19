package com.skilldistillery.jpabuzzfinder.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpabuzzfinder.entities.AccountInfo;
import com.skilldistillery.jpabuzzfinder.entities.User;

@Service
@Transactional
public class AccountInfoDAOImpl implements AccountInfoDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public AccountInfo findById(int id) {
		
		return em.find(AccountInfo.class, id);
	}
	
	
	@Override
	public AccountInfo update(int id, AccountInfo info) {
		
		AccountInfo dbInfo = em.find(AccountInfo.class, id);
		System.out.println("Before update: " + dbInfo);
	
		dbInfo.setFirstName(info.getFirstName());
		dbInfo.setLastName(info.getLastName());
		
		em.flush();
		System.out.println("After update: " + dbInfo);
		return dbInfo;
	}
	
	
	@Override
	public boolean destroy(int id) {
		
		AccountInfo destroyInfo = em.find(AccountInfo.class, id);
		em.remove(destroyInfo);
		
		boolean successfulKickOut;
		successfulKickOut =!em.contains(destroyInfo);
		
		return successfulKickOut;
	}
	
	@Override
	public AccountInfo create(AccountInfo info) {
		info.setUser(em.find(User.class, info.getUser().getId()));
//		em.persist(info.getAddress());
//		em.persist(info.getUser());
		System.out.println("Info before persist:  " + info);
		em.persist(info);
		System.out.println("Info after persit: " + info);
		
		em.flush();
		return info;
	}
}
