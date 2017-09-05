package com.sopra.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.sopra.dao.IFAQDAO;
import com.sopra.model.FAQ;

@Component
@Scope("request")
public class FaqController {
	private int id;
	private String question;
	private String reponse;
	
	@Autowired
	private IFAQDAO FAQDAO;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
	
	@PostConstruct
	private void init() {
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		if (req.getParameter("id") != null) {
			this.id = Integer.parseInt(req.getParameter("id"));
			
			FAQ faq = FAQDAO.find(this.id);
			
			this.question = faq.getQuestion();
			this.reponse = faq.getReponse();
		}
	}
	
	public String submit() {
		
		FAQ faq = new FAQ();
		
		faq.setId(this.id);
		
		faq.setQuestion(getQuestion());
		
		faq.setReponse(getReponse());
		
		FAQDAO.save(faq);
		
		return "listeFAQ";
	}
	
	public List<FAQ> getListe() {
		
		return FAQDAO.findAll();
	}
	
}
