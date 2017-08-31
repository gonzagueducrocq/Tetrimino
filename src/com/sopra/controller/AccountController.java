package com.sopra.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.model.Admin;

@Controller
public class AccountController {

	@RequestMapping(value = "/account/logIn", method = RequestMethod.GET)
	public String subscribe(Model model) {
		return "logIn";
	}

	@ModelAttribute("user")
	public Admin initAdmin() {
		Admin administrateur = new Admin();
		return administrateur;
	}

	@RequestMapping(value = "/account/logIn", method = RequestMethod.POST)
	public String subscribe(@Valid @ModelAttribute("user") Admin administrateur, BindingResult result) {

		if (result.hasErrors()) {
			return "logIn";
		}

		return "redirect:/home/";
	}
	
	
	
	
	@RequestMapping(value="/account/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/account/logIn";
	}
}
