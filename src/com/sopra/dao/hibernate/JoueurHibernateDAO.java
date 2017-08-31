package com.sopra.dao.hibernate;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IJoueurDAO;
import com.sopra.model.Joueur;
import com.sopra.model.Personne;


@Repository
@Transactional
public class JoueurHibernateDAO implements IJoueurDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Joueur> findAll() {
		try {
			return (List<Joueur>) em.createQuery("FROM Joueur").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Joueur find(int id) {
		try {
			return em.find(Joueur.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Joueur save(Joueur joueur) {
		return em.merge(joueur);
	}

	@Override
	public void delete(Joueur joueur) {
		em.remove(em.merge(joueur));

	}

	@Override
	public Joueur login(String username, String password) {
		try {
			return em.createQuery("FROM Joueur j WHERE j.username = :username AND j.password = :password", Joueur.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
		}
		
		catch (NoResultException e) {
			return null;
		}
	}

}
