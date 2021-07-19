package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.BeerDAO;
import com.skilldistillery.jpabuzzfinder.entities.Beer;

@Controller
public class BeerController {
	
	@Autowired
	private BeerDAO beerDao;
	
	
	@RequestMapping(path ="displayBeer.do")
	public String showBeer() {
		return "beerResults";
	}
	
	@RequestMapping(path = "rateBeer.do")
	public String rateBeer(Model model, int beerId) {
model.addAttribute("review", beerDao.findBeerById(beerId));
	return "profile";
}

}
