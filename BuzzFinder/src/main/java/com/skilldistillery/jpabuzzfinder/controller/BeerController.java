package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.BeerDAO;

@Controller
public class BeerController {
	
	@Autowired
	private BeerDAO beerDao;
	
	@RequestMapping(path={"/", "home.do"})
	public String home(Model model) {
		model.addAttribute("DEBUG", beerDao.findBeerById(1));
		return "home";
	}
	
	

}
