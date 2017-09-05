package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sopra.dao.IFAQDAO;
import com.sopra.model.FAQ;

@Controller
public class FAQController {

	private String question;
	private String reponse;
	
	@Autowired
	private IFAQDAO FAQDAO;
	
	
	public String getQuestion() {
		return question;
	}




	public void setQuestion(String question) {
		this.question = question;
	}




	public String getReponse() {
		return reponse;
	}




	public void setReponse(String reponse) {
		this.reponse = reponse;
	}




	public String submit() {
		
		FAQ faq = new FAQ();
		
		faq.setQuestion(getQuestion());
		
		faq.setReponse(getReponse());
		
		FAQDAO.save(faq);
		
		return "listeFAQ";
	}
	
	
	
}
