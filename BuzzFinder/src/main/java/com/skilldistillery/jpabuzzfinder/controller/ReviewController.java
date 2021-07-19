package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.jpabuzzfinder.data.ReviewDAO;
import com.skilldistillery.jpabuzzfinder.entities.BeerReview;
import com.skilldistillery.jpabuzzfinder.entities.BreweryReview;

@Controller
public class ReviewController {

	@Autowired
	private ReviewDAO reviewDao;

	@RequestMapping(path = { "/", "home.do" })
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(path = "createBreweryReview.do")
	public String createBrewReview(RedirectAttributes redir, BeerReview beRev) {
return null;
	}
	
	@RequestMapping(path = "deleteBreweryReview.do")
	public String deleteBreweryReview(Model model, BreweryReview brewRev) {
		
		BreweryReview deleteRev = reviewDao.deleteBrewComment(brewRev)
		return null;
	}
	
	
	@RequestMapping (path = "createBeerReview.do")
	public String createBeerReview(RedirectAttributes redir, BreweryReview brewRev) {
		return null;
	}
	
	
}
