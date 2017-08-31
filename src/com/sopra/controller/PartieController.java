package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sopra.dao.IPartieDAO;

@Controller
public class PartieController
{
	@Autowired
	private IPartieDAO partieDAO;
	
	
	@RequestMapping("/parties")
	public String getListeParties(Model model) {
		model.addAttribute("parties", partieDAO.findAll());
		
		return "parties";
	}
}