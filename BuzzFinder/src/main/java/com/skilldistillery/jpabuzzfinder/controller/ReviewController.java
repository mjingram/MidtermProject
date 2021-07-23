package com.skilldistillery.jpabuzzfinder.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

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
		model.addAttribute("breweryId", breweryId);

		return "breweryReview";
	}

	@RequestMapping(path = "beerReview.do")
	public String reviewBeer(Model model, int beerId, String name) {
		model.addAttribute("name", beerDao.findBeerByName(name));
		model.addAttribute("beerId", beerId);
		return "beerReview";
	}

	@RequestMapping(path = "createBreweryReview.do")
	public String createBrewReview(HttpSession session, LocalDate reviewDate, String comment, Brewery brewery, int rating,
			String again, String feature, String favorite, Integer breweryId) {
		
		brewery = breweryDao.findBreweryById(breweryId);
		BreweryReview newReview = new BreweryReview(0, reviewDate, comment, brewery, favorite, rating,
				again, feature);
		
		newReview.setUser((User)session.getAttribute("user"));

		BreweryReview dbAddedReview = reviewDao.addBreweryReview(newReview);

		session.setAttribute("newBreweryReview", dbAddedReview);
		brewery = breweryDao.findBreweryById(breweryId);
		session.setAttribute("brewery", brewery);
		session.setAttribute("breweryReviews", reviewDao.findReviewByBreweryId(brewery.getId()));
		return "redirect:breweryDetails.do?id="+breweryId;
	}

	@RequestMapping(path = "createBeerReview.do")
	public String createBeerReview(HttpSession session, LocalDate reviewDate, String comment, Beer beer, String taste,
			String body, int rating, String again, Integer beerId) {
		beer = beerDao.findBeerById(beerId);
		BeerReview newReview = new BeerReview(0, reviewDate, comment, beer, taste, body, rating, again);
		newReview.setUser((User)session.getAttribute("user"));
		BeerReview dbAddedReview = reviewDao.addBeerReview(newReview);

		session.setAttribute("newBeerReview", dbAddedReview);
		session.setAttribute("beer", beer);
		session.setAttribute("beerReviews", reviewDao.findReviewByBeerId(beer.getId()));
		return "redirect:beerDetails.do?id="+beerId;

	}
	@RequestMapping(path = "deleteBreweryReview.do")
	public String removeBreweryReview(HttpSession session, int reviewId, int breweryId) {
		
		session.setAttribute("removeReview", reviewDao.deleteBreweryReview(reviewId));
//		session.setAttribute("breweryId", breweryDao.findBreweryById(breweryId));
		
		return "singleBreweryResult";
	}

	@RequestMapping(path = "deleteBeerReview.do")
	public String deleteBeerReview(HttpSession session, int reviewId, int beerId) {
		
		
		
		session.setAttribute("removeReview", reviewDao.deleteBeerReview(beerId));


		return "singleBeerResult";

	}

}
