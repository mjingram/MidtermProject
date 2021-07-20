package com.skilldistillery.jpabuzzfinder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.AccountInfoDAO;
import com.skilldistillery.jpabuzzfinder.data.AddressDAO;
import com.skilldistillery.jpabuzzfinder.data.UserDAO;
import com.skilldistillery.jpabuzzfinder.entities.AccountInfo;
import com.skilldistillery.jpabuzzfinder.entities.Address;
import com.skilldistillery.jpabuzzfinder.entities.User;

@Controller
public class AccountInfoController {
	
	@Autowired
	private AccountInfoDAO accountDAO;
	
	@Autowired
	private AddressDAO addrDAO;
	
	@Autowired
	private UserDAO userDAO;

	
	//Search Mappings
	
	@RequestMapping(path={"sendAccountId.do"})
	public String getAccountId(int id, Model model, HttpSession session) {
			
	session.setAttribute("accountInfo", accountDAO.findById(id)); 
	session.setAttribute("addressInfo", addrDAO.findAddressById(id));
	return "profile";
	}
		
	//Update Mappings
	
	//Go to update page and send the current account info to the form
	@RequestMapping(path={"updateAccountPage.do"})
	public String toUpdatePage(int id, Model model) {
//		model.addAttribute("accountId", id);
		
//		model.addAttribute("accountInfo", accountDAO.findById(id));
//		model.addAttribute("addressInfo", addrDAO.findAddressById(id));
		
		return "updateAccount";
	}
	
	//Send new info to the database and return to profile
	@RequestMapping(path={"sendUpdateAccount.do"})
		public String updateAccount(int id, AccountInfo updateAccount, Model model, HttpSession session) {
			AccountInfo info = accountDAO.update(id, updateAccount);
			
			session.setAttribute("accountInfo", info); 
			session.setAttribute("addressInfo", info.getAddress()); 
			System.out.println("****" + info.getAddress());
			return "profile";
		}
	
	//Delete Mappings
	
	@RequestMapping(path={"deleteAccountPage.do"})
	public String toDeletePage(int id, Model model) {
		model.addAttribute("accountId", id);
		model.addAttribute("accountInfo", accountDAO.findById(id));
		model.addAttribute("addressInfo", addrDAO.findAddressById(id));
		
		return "deleteAccount";
	}
	
	@RequestMapping(path={"sendAccountDelete.do"})
	public String deleteAccount(int id, AccountInfo deleteAccount, Model model) {
		accountDAO.destroy(id);
		//model.addAttribute("account",dao.findById(accountId) ); //Debug
		return "home";
	}
	
	//Create Mappings
	@RequestMapping(path={"sendAccountCreate.do"})
	public String createAccount(String firstName, String lastName, String street, String city, String state, String zipcode, Model model, HttpSession session) {
		
		AccountInfo newAccount = new AccountInfo(firstName, lastName);
		Address newAddress = new Address(city, state, zipcode, street);
	
		newAccount.setAddress(newAddress);
		User newUser = (User)session.getAttribute("user");
	
		newAccount.setUser(newUser);
		AccountInfo dbAddedAccount = accountDAO.create(newAccount);
		System.out.println(dbAddedAccount);
		session.setAttribute("accountInfo", dbAddedAccount); 
		session.setAttribute("addressInfo", dbAddedAccount.getAddress());
		return "profile";
	}
	
	// Login mappings
	
	@RequestMapping(path={"login.do"})
	public String login() {
		return "login";
	}
	
	@RequestMapping(path={"signup.do"})
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(path={"search.do"})
	public String search() {
		return "search";
	}
	
	@RequestMapping(path={"profile.do"})
	public String profile() {
		return "profile";
	}

}
