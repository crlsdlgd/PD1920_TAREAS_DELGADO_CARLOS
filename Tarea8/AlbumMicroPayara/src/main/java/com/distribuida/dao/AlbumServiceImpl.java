package com.distribuida.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.distribuida.dto.Album;


@ApplicationScoped
public class AlbumServiceImpl implements AlbumService{

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
	public List<Album> findAll() {
		List<Album> singers;
		singers = em.createQuery("SELECT u FROM Album u", Album.class).getResultList();
		return singers;
	}

	@Override
	public Album findById(Integer id) {
		List<Album> singers;
		singers = em.createQuery("SELECT u FROM Album u WHERE id = :id", Album.class).setParameter("id", id).getResultList();
		return singers.get(0);
	}

	

}
