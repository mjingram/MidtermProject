package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.UserDAO;
import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	
	
	@RequestMapping("getUserProfile.do")
	public String getUserProfile(String username, String password, Model model) {
		
		model.addAttribute("user", userDao.login(username, password));
		
		return "account";
	}
	
	
	@RequestMapping("createUserProfile.do")
	public String createUserProfile(User user, Model model) {
		
		model.addAttribute("user", userDao.createUser(user));
		
		return "profile";
	}
	
	
	@RequestMapping("updateUserProfile.do")
	public String updateUserProfile(User user, String password, Model model) {
		
		model.addAttribute("user", userDao.updateUsernameAndPassword(password, user));
		
		return "profile";
	}
	
	
	@RequestMapping("deleteUserProfile.do")
	public String deleteUserProfile(User user, Model model) {
		
		model.addAttribute("user", userDao.deleteUser(user));
		
		return "profile";
	}
	
	
	@RequestMapping("addFavoriteBeer.do")
	public String addFavoriteBeer(Beer beer, User user, Model model) {
		
		model.addAttribute("beer", userDao.addFavBeer(user, beer));
		
		return "profile";
	}
	
	
	@RequestMapping("addFavoriteBrewery.do")
	public String addFavoriteBrewery(Brewery brewery, User user, Model model) {
		
		model.addAttribute("beer", userDao.addFavBrewery(user, brewery));
		
		return "profile";
	}

	
	@RequestMapping("removeFavoriteBeer.do")
	public String removeFavoriteBeer(Beer beer, User user, Model model) {
		
		model.addAttribute("beer", userDao.removeFavBeer(user, beer));
		
		return "profile";
	}
	
	
	@RequestMapping("removeFavoriteBrewery.do")
	public String removeFavoriteBrewery(Brewery brewery, User user, Model model) {
		
		model.addAttribute("beer", userDao.removeFavBrewery(user, brewery));
		
		return "profile";
	}
}
