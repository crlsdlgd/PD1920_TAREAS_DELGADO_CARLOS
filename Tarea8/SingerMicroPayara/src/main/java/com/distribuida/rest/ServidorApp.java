package com.distribuida.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class ServidorApp extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return Set.of(SingerRest.class);
	}
	
}
