package com.skilldistillery.jpabuzzfinder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.BeerDAO;
import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.User;

@Controller
public class BeerController {
	
	@Autowired
	private BeerDAO beerDao;
	
	
	@RequestMapping(path ="displayBeer.do")
	public String showBeer(HttpSession session, String name) {
		session.setAttribute("beers", beerDao.findBeerByName(name));
		
		return "beerResults";
	}
	
	@RequestMapping(path ="getBeerByStyle.do")
	public String showBeerByStyle(HttpSession session, String name) {
		session.setAttribute("beers", beerDao.findBeerByName(name));
		
		return "beerResults";
	}
	
	@RequestMapping(path = "rateBeer.do")
	public String rateBeer(Model model, int beerId) {
		
model.addAttribute("review", beerDao.findBeerById(beerId));
	return "profile";
}
	
//	@RequestMapping(path = "getBeerByName")
//	public String getBeerByName(String name, HttpSession session) {
//		
//		Beer newBeer = beerDao.findBeerByName(name);
//		session.setAttribute("name", newBeer.getName());
//		session.setAttribute("beerStyle", newBeer.getBeerStyle());
//		session.setAttribute("brewery", newBeer.getBrewery());
//		session.setAttribute("abv", newBeer.getAbv());
//		session.setAttribute("ibu", newBeer.getIbu());
//		session.setAttribute("ounces", newBeer.getOunces());
//		
//		return "singleBeerResult";
//	}
	
	
	

//	getBeerByStyle.do shows a list of beers
	
}
