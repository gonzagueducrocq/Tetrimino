package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Tetrimino;



@Repository
@Transactional
public class TetriminoHibernateDAO implements ITetriminoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Tetrimino> findAll() {
		try {
			return (List<Tetrimino>)em.createQuery("FROM Tetrimino").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Tetrimino find(int id) {
		try {
			return em.find(Tetrimino.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Tetrimino save(Tetrimino tetrimino) {
		return em.merge(tetrimino);
	}

	@Override
	public void delete(Tetrimino tetrimino) {
		em.remove(em.contains(tetrimino) ? tetrimino : em.merge(tetrimino));

	}

}
