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
import com.skilldistillery.jpabuzzfinder.entities.User;

@Controller
public class ReviewController {

	@Autowired
	private ReviewDAO reviewDao;
	
	@Autowired
	private BreweryDAO breweryDao;
	
	@Autowired
	private BeerDAO beerDao;
	
	@RequestMapping(path = "breweryReview.do")
	public String reviewBrewery(Model model, int breweryId, String name) {
		
		model.addAttribute("name", breweryDao.findBreweryByName(name));
		
	return "breweryReview";
	}
	
	
	
	
	@RequestMapping(path = "beerReview.do")
	public String reviewBeer(Model model, int beerId, String name) {
		model.addAttribute("name", beerDao.findBeerByName(name));
		return "beerReview";
	}

	@RequestMapping(path = "createBreweryReview.do")
	public String createBrewReview(Model model, LocalDate reviewDate,String comment, Brewery brewery, int rating, String again, String feature, String favoriteBeer  ) {
		BreweryReview newReview = new BreweryReview( brewery.getId(), reviewDate,  comment,  brewery,  favoriteBeer,
				 rating,  again,  feature);
		BreweryReview dbAddedReview = reviewDao.addBreweryReview(newReview);
		
		model.addAttribute("newBreweryReview", dbAddedReview);
		model.addAttribute("breweryId", breweryDao.findBreweryById(brewery.getId()));
return "singleBreweryResult";
	}
	
	
	
	@RequestMapping(path = "deleteBreweryReview.do")
	public String deleteBreweryReview(Model model, int reviewId, int breweryId) {
		reviewDao.deleteBreweryReview(reviewId);
		model.addAttribute("breweryId", breweryDao.findBreweryById(breweryId));
		
		return "singleBreweryResult";
	}
	
	
	@RequestMapping (path = "createBeerReview.do")
	public String createBeerReview(Model model, LocalDate reviewDate, String comment, Beer beer, String taste, String body, int rating, String again) {
		BeerReview newReview = new BeerReview( beer.getId(),  reviewDate,  comment,  beer,  taste,  body,  rating,
				 again );
		BeerReview dbAddedReview = reviewDao.addBeerReview(newReview);
		
		model.addAttribute("newBeerReview", dbAddedReview);
		model.addAttribute("beer", beerDao.findBeerById(beer.getId()));
return "singleBeerResult";	}
	
	@RequestMapping(path = "deleteBeerReview.do")
	public String deleteBeerReview(Model model, int reviewId, int beerId) {
		reviewDao.deleteBeerReview(beerId);
		model.addAttribute("beerId", beerDao.findBeerById(beerId));
		
		return "singleBeerResult";

	}
	
	
}
