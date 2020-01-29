package com.distribuida.conexion;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.config.Config;

@ApplicationScoped
public class DBConfig {
	
	/*
	public static final String DRIVER_CLASS = "org.postgresql.Driver";
	public static final String URL = "jdbc:postgresql://localhost:5432/examen01";
	public static final String USER = "distribuida";
	public static final String PASS = "distribuida";
	*/
	
	@Inject
	@ConfigProperty(name="texto")
	private String mensaje;
	
	@Inject
	@ConfigProperty(name="driver_class")
	private String DRIVER_CLASS;
	
	@Inject
	@ConfigProperty(name="url")
	private String URL;
	
	@Inject
	@ConfigProperty(name="user")
	private String USER;
	
	@Inject
	@ConfigProperty(name="pass")
	private String PASS;
	
	@ApplicationScoped
	@Produces
	public DataSource dataSource( ) {
		
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName( DRIVER_CLASS );
		ds.setUrl( URL );
		ds.setUsername( USER );
		ds.setPassword( PASS );
		
		//System.out.println(mensaje+" "+DRIVER_CLASS+"  "+URL+"  "+USER+"  "+PASS);
		
		return ds;
	}

}