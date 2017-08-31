package com.sopra.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="figure")
public class Figure {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="FIG_ID")
	private int id;

	@Column (name="FIG_ORD")
	@NotNull
	private int ordre;

	@ManyToOne
	@JoinColumn(name="FIG_TETRIMINO_ID")
	@JsonIgnore
	private Tetrimino tetrimino;

	@OneToMany(mappedBy="figure")
	private List<Bloc> blocs;

	public Bloc blocExistant (int x, int y) {
		
		for (Bloc bloc : blocs) {
			if (bloc.getX() == x && bloc.getY() == y)
				return bloc;
		}
		return null;
	}

	public Tetrimino getTetrimino() {
		return tetrimino;
	}

	public void setTetrimino(Tetrimino tetrimino) {
		this.tetrimino = tetrimino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public List<Bloc> getBlocs() {
		return blocs;
	}

	public void setBlocs(List<Bloc> blocs) {
		this.blocs = blocs;
	}
}
