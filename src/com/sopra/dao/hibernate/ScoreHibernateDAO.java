package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IScoreDAO;
import com.sopra.model.Score;

@Repository
@Transactional
public class ScoreHibernateDAO implements IScoreDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Score> findAll() {
		try {
			return (List<Score>)em.createQuery("FROM Score").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Score find(int id) {
		try {
			return em.find(Score.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Score save(Score score) {
		return em.merge(score);
	}

	@Override
	public void delete(Score score) {
		em.remove(em.merge(score));
	}

}
