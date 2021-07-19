package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.AccountInfoDAO;
import com.skilldistillery.jpabuzzfinder.data.AddressDAO;
import com.skilldistillery.jpabuzzfinder.entities.AccountInfo;

@Controller
public class AccountInfoController {
	
	@Autowired
	private AccountInfoDAO accountDAO;
	
	@Autowired
	private AddressDAO addrDAO;

	
	//Search Mappings
	
	@RequestMapping(path={"sendAccountId.do"})
	public String getAccountId(int accountId, Model model) {
			
	model.addAttribute("accountInfo", accountDAO.findById(accountId)); 
	model.addAttribute("addressInfo", addrDAO.findAddressById(accountId));
	return "profile";
	}
		
	//Update Mappings
	
	//Go to update page and send the current account info to the form
	@RequestMapping(path={"updateAccountPage.do"})
	public String toUpdatePage(int accountId, Model model) {
		model.addAttribute("accountId", accountId);
		model.addAttribute("accountInfo", accountDAO.findById(accountId));
		model.addAttribute("addressInfo", addrDAO.findAddressById(accountId));
		
		return "update";
	}
	
	//Send new info to the database and return to profile
	@RequestMapping(path={"sendAccountUpdate.do"})
		public String updateAccount(int accountId, AccountInfo updateAccount, Model model) {

			model.addAttribute("account", accountDAO.update(accountId, updateAccount)); 
			return "profile";
		}
	
	//Delete Mappings
	
	@RequestMapping(path={"deleteAccountPage.do"})
	public String toDeletePage(int accountId, Model model) {
		model.addAttribute("accountId", accountId);
		model.addAttribute("accountInfo", accountDAO.findById(accountId));
		model.addAttribute("addressInfo", addrDAO.findAddressById(accountId));
		
		return "delete";
	}
	
	@RequestMapping(path={"sendAccountDelete.do"})
	public String deleteAccount(int accountId, AccountInfo deleteAccount, Model model) {
		accountDAO.destroy(accountId);
		//model.addAttribute("account",dao.findById(accountId) ); //Debug
		return "home";
	}
	
	//Create Mappings
	@RequestMapping(path={"sendAccountCreate.do"})
	public String createAccount(String firstName, String lastName, String street, String city, String state, String zipcode, String username, String password, Model model) {
		
		AccountInfo newAccount = new AccountInfo(firstName, lastName);
		AccountInfo dbAddedAccount = accountDAO.create(newAccount);
		System.out.println(dbAddedAccount);
		//model.addAttribute("account", dao.findById(currentPage)); //Debug
		return "account";
	}
	
	// Login mappings
	
	@RequestMapping(path={"login.do"})
	public String login() {
		return "login";
	}
	
	
	
	
}
