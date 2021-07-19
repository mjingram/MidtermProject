package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.UserDAO;
import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping("getUserProfile.do")
	public String getUserProfile(String username, String password, Model model) {
		model.addAttribute("user", userDao.login(username, password));
		
		return "profile";
	}
	
	@RequestMapping("createUserProfile.do")
	public String createUserProfile(User user, Model model) {
		model.addAttribute("user", userDao.createUser(user));
		
		return "profile";
	}
	
	@RequestMapping("updateUserProfile.do")
	public String updateUserProfile(User user, Model model) {
		
		model.addAttribute("user", userDao.deleteUser(user));
		
		return "profile";
	}
	
	@RequestMapping("deleteUserProfile.do")
	public String deleteUserProfile(User user, Model model) {
		
		model.addAttribute("user", userDao.deleteUser(user));
		
		return "profile";
	}
	
	@RequestMapping("AddFavoriteBeer.do")
	public String addFavoriteBeer(Beer beer, User user, Model model) {
		model.addAttribute("beer", userDao.addFavBeer(user, beer));
		
		return "profile";
	}

}
