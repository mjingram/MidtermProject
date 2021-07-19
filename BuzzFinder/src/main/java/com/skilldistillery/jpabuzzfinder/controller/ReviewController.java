package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.ReviewDAO;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewDAO reviewDao;
	
	@RequestMapping(path = {"/", "home.do"})
	public String homeBeer(Model model) {
	model.addAttribute("DEBUG", reviewDao.addBeerComment("Good Beer"));
return "home";
	}
	
	@RequestMapping(path = {"/", "home.do"})
	public String homeBrew(Model model) {
		model.addAttribute("DEBUG", reviewDao.addBeerComment("Good Brewery"));
		return "home";
	}
}
