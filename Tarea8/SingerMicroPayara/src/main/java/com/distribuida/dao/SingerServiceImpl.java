package com.distribuida.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.dto.Singer;


@ApplicationScoped
public class SingerServiceImpl implements SingerService{

	@Inject private EntityManager em;
	
	/*
	@Override
	public Singer create(Singer singer) {
		em.getTransaction().begin();
		em.persist(singer);
		em.getTransaction().commit();
		return singer;
	}

	@Override
	public Singer update(Singer singer) {
		em.getTransaction().begin();
		em.merge(singer);
		em.getTransaction().commit();
		return singer;
	}
	
	@Override
	public void delete(Integer id) {
		em.getTransaction().begin();
		Singer singer = em.createQuery("SELECT u FROM Singer u WHERE id = :id", Singer.class).setParameter("id", id).getResultList().get(0);
		em.remove(singer);
		em.getTransaction().commit();
		
	}
	
	*/

	@Override
	public List<Singer> findAll() {
		List<Singer> singers;
		singers = em.createQuery("SELECT u FROM Singer u", Singer.class).getResultList();
		return singers;
	}

	@Override
	public Singer findById(Integer id) {
		List<Singer> singers;
		singers = em.createQuery("SELECT u FROM Singer u WHERE id = :id", Singer.class).setParameter("id", id).getResultList();
		return singers.get(0);
	}

	

}
