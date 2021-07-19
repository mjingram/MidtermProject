package com.skilldistillery.jpabuzzfinder.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.BeerDAO;
import com.skilldistillery.jpabuzzfinder.data.BreweryDAO;
import com.skilldistillery.jpabuzzfinder.data.ReviewDAO;
import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.BeerReview;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;
import com.skilldistillery.jpabuzzfinder.entities.BreweryReview;

@Controller
public class ReviewController {

	@Autowired
	private ReviewDAO reviewDao;
	
	@Autowired
	private BreweryDAO breweryDao;
	
	@Autowired
	private BeerDAO beerDao;

	@RequestMapping(path = "createBreweryReview.do")
	public String createBrewReview(Model model, LocalDate reviewDate,String comment, Brewery brewery, int breweryId  ) {
		BreweryReview newReview = new BreweryReview(reviewDate, comment, brewery );
		BreweryReview dbAddedReview = reviewDao.addBrewComment(newReview);
		
		model.addAttribute("new Brewery Review", dbAddedReview);
		model.addAttribute("brewery Id", breweryDao.findBreweryById(breweryId));
return "singleBreweryResult";
	}
	
	
	
	@RequestMapping(path = "deleteBreweryReview.do")
	public String deleteBreweryReview(Model model, int reviewId, int breweryId) {
		reviewDao.deleteBrewComment(reviewId);
		model.addAttribute("brewery Id", breweryDao.findBreweryById(breweryId));
		
		return "singleBreweryResult";
	}
	
	
	@RequestMapping (path = "createBeerReview.do")
	public String createBeerReview(Model model, LocalDate reviewDate,String comment, Beer beer, int beerId ) {
		BeerReview newReview = new BeerReview(reviewDate, comment, beer );
		BeerReview dbAddedReview = reviewDao.addBeerComment(newReview);
		
		model.addAttribute("new Beer Review", dbAddedReview);
		model.addAttribute("Beer Id", beerDao.findBeerById(beerId));
return "singleBeerResult";	}
	
	@RequestMapping(path = "deleteBeerReview.do")
	public String deleteBeerReview(Model model, int reviewId, int beerId) {
		reviewDao.deleteBeerComment(beerId);
		model.addAttribute("beer Id", beerDao.findBeerById(beerId));
		
		return "singleBeerResult";

	}
	
	
}
