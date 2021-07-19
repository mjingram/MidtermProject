package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.AccountInfoDAO;
import com.skilldistillery.jpabuzzfinder.entities.AccountInfo;

@Controller
public class AccountInfoController {
	
	@Autowired
	private AccountInfoDAO dao;
	
	@RequestMapping(path={"/", "home.do"})
	public String home(Model model, int id) {
		model.addAttribute("accountInfo", dao.findById(id)); //Debug
		return "home";
	}
	
	//Search Mappings
	
		@RequestMapping(path={"sendAccountId.do"})
		public String getAccountId(int accountId, Model model) {
			
			model.addAttribute("accountInfo", dao.findById(accountId)); //Debug
			return "account";
		}
		
	//Update Mappings
		
	@RequestMapping(path={"sendUpdate.do"})
		public String updateAccount(int accountId, AccountInfo updateAccount, Model model) {

			model.addAttribute("account", dao.update(accountId, updateAccount)); //Debug
			return "account";
		}
	
	//Delete Mappings
	
	@RequestMapping(path={"sendDelete.do"})
	public String deleteAccount(int accountId, AccountInfo deleteAccount, Model model) {
		dao.destroy(accountId);
		//model.addAttribute("account",dao.findById(accountId) ); //Debug
		return "account";
	}
	
	//Create Mappings
	@RequestMapping(path={"sendCreate.do"})
	public String createAccount(String firstName, String lastName, Model model) {
		
		AccountInfo newAccount = new AccountInfo(firstName, lastName);
		AccountInfo dbAddedAccount = dao.create(newAccount);
		System.out.println(dbAddedAccount);
		//model.addAttribute("account", dao.findById(currentPage)); //Debug
		return "account";
	}
	
}
