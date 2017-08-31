package com.sopra.dao;

import com.sopra.model.Joueur;

public interface IJoueurDAO extends IDAO<Joueur> {
	public Joueur login(String username, String password);
}
