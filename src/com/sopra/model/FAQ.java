package com.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="FAQ")
public class FAQ {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="FAQ_ID")
	private int id;
	
	@Column (name="FAQ_QUES")
	private String question;
	
	@Column (name="FAQ_REP", columnDefinition="text")
	private String reponse;

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
	
	
}
