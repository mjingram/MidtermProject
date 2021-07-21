package com.skilldistillery.jpabuzzfinder.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.BeerDAO;
import com.skilldistillery.jpabuzzfinder.data.BreweryDAO;
import com.skilldistillery.jpabuzzfinder.data.UserDAO;
import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private BreweryDAO breweryDAO;
	
	@Autowired
	private BeerDAO beerDAO;
	
	@RequestMapping("getUserProfile.do")
	public String getUserProfile(String username, String password, HttpSession session) {
		
		User newUser = userDao.login(username, password);
		session.setAttribute("accountInfo", newUser.getAccountInfo());
		session.setAttribute("addressInfo", newUser.getAccountInfo().getAddress());
		session.setAttribute("user", newUser);
		
		return "profile";
	}
	
	
	@RequestMapping("createUserProfile.do")
	public String createUserProfile(User user, Model model, HttpSession session) {
		
		session.setAttribute("user", userDao.createUser(user));
		
		return "account";
	}
	
	
	@RequestMapping("updateUserProfile.do")
	public String updateUserProfile(int userId, String password, Model model) {
		
		model.addAttribute("user", userDao.updateUsernameAndPassword(password, userId));
		
		return "profile";
	}
	
	
	@RequestMapping("deleteUserProfile.do")
	public String deleteUserProfile(int userId, Model model) {
		
		model.addAttribute("user", userDao.deleteUser(userId));
		
		return "profile";
	}
	
	
	@RequestMapping("addFavoriteBeer.do")
	public String addFavoriteBeer(Beer beer, int userId, Model model) {
		
		model.addAttribute("beer", userDao.addFavBeer(userId, beer));
		
		return "profile";
	}
	
	
	@RequestMapping("addFavoriteBrewery.do")
	public String addFavoriteBrewery(Brewery brewery, int userId, Model model) {
		
		model.addAttribute("beer", userDao.addFavBrewery(userId, brewery));
		
		return "profile";
	}

	
	
	
	@RequestMapping("removeFavoriteBeer.do")
	public String removeFavoriteBeer(int id, HttpSession session) {
		session.setAttribute("beerRemove", beerDAO.removeFavoriteBeer(id));
		return "profile";
	}
	
	
	@RequestMapping("removeFavoriteBrewery.do")
	public String removeFavoriteBrewery(int id, Model model) {
		model.addAttribute("breweryRemove", breweryDAO.removeFavoriteBrewery(id));
		return "profile";
	}
	@RequestMapping("breweryFavorites.do")
	public String favoriteBreweries(int id, HttpSession session) {
		session.setAttribute("faveBreweries", breweryDAO.favoriteList(id));
		return "profile";
	}
	
	
	
	@RequestMapping("beerFavorites.do")
	public String favoriteBeers(int id, HttpSession session) {
		session.setAttribute("faveBeers", beerDAO.faveBeerList(id));

		return "profile";
	}
	@RequestMapping("removeFaveBrewery.do")
	public String removeFaveBrewery(int id, HttpSession session) {
		
		return "profile";
	}
	
	
}
