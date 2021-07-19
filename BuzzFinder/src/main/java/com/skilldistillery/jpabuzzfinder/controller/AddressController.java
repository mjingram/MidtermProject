package com.skilldistillery.jpabuzzfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpabuzzfinder.data.AddressDAO;

@Controller
public class AddressController {

	@Autowired
	AddressDAO addressDAO;
	
	@RequestMapping(path = { "/", "home.do" })
	public String index() {
		return "index";
	}
}
