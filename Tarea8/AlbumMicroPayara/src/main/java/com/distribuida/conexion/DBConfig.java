package com.distribuida.conexion;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class DBConfig {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("distribuida-PU");
	
	@ApplicationScoped
	@Produces
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	
}
