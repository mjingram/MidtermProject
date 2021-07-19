package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jpabuzzfinder.data.AddressDAO;
import com.skilldistillery.jpabuzzfinder.entities.Address;

@Controller
public class AddressController {

	@Autowired
	AddressDAO addressDAO;
	
//	@RequestMapping(path = { "/", "home.do" })
//	public String index() {
//		return "home";
//	}
	@RequestMapping(path="createAddress.do", method = RequestMethod.POST)
	public String createBrew(Address addr, Model model) {
		model.addAttribute("Address", addressDAO.createAddress(addr));
		return "profile";
	}
	@RequestMapping(path="deleteAddress.do", method = RequestMethod.GET)
	public String deleteBrewery(int id) {
		if(addressDAO.removeAddress(id)) {
			return "delete";
		}
		return "profile";
	}
	@RequestMapping(path="updateAddress.do")
	public String updateBrewery(Integer id, String street, String city, String state, String zipCode) {
		Address addr = new Address();
		addr.setStreet(street);
		addr.setCity(city);
		addr.setState(state);
		addr.setZipcode(zipCode);
		System.out.println(addressDAO.updateAddress(id, addr));
		return "profile";
	}
}
