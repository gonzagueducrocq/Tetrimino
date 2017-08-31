package com.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="bloc")
public class Bloc
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BLO_ID")
	private int id;
	
	@Column(name="BLO_X")
	private int x;
	
	@Column(name="BLO_Y")
	private int y;
	
	@ManyToOne
	@JoinColumn(name="BLO_FIGURE_ID")
	@JsonIgnore
	private Figure figure;
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Figure getFigure() {
		return figure;
	}
	
	public void setFigure(Figure figure) {
		this.figure = figure;
	}
}