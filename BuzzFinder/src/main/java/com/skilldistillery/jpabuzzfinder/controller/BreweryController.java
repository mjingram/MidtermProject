package com.skilldistillery.jpabuzzfinder.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jpabuzzfinder.data.BreweryDAO;
import com.skilldistillery.jpabuzzfinder.entities.Address;
import com.skilldistillery.jpabuzzfinder.entities.Beer;
import com.skilldistillery.jpabuzzfinder.entities.Brewery;

@Controller
public class BreweryController {

	@Autowired
	BreweryDAO breweryDAO;



	@RequestMapping(path="createBrewery.do", method = RequestMethod.POST)
	public String createBrew(Brewery brewery, Model model) {
		model.addAttribute("Brewery", breweryDAO.createBrewery(brewery));
		return "home";
	}
	
	
	@RequestMapping(path="deleteBrewery.do", method = RequestMethod.GET)
	public String deleteBrewery(int id) {
		if(breweryDAO.removeBrewery(id)) {
			return "delete";
		}
		return "home";
	}
	
	
	@RequestMapping(path={"getBreweryByName.do"})
	public String getBreweryByName(HttpSession session, String name) {
		
		session.setAttribute("breweries" , breweryDAO.findBreweryByName(name));
		
		return "breweryResults";
		
	}
	
	
	@RequestMapping(path={"getBreweryByLocation.do"})
	public String getBreweryByLocation(HttpSession session, String city, String state) {
		
		session.setAttribute("breweries" , breweryDAO.findBreweryByLocation(city, state));
		
		return "breweryResults";
		
	}
	
	
	
/////////// Brewery Can Not Be Edited by Users, Method below is just in case /////////
//	@RequestMapping(path="updateBrewery.do")
//	public String updateBrewery(Integer id, String name, Address addr, List<Beer> beers, String logo) {
//		Brewery brewery = new Brewery();
//		brewery.setName(name);
//		brewery.setAddress(addr);
//		brewery.setBeer(beers);
//		brewery.setLogo(logo);
//		System.out.println(breweryDAO.updateBrewery(id, brewery));
//		return "";
//	} 
}
