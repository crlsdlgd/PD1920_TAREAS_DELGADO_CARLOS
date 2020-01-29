package com.distribuida.rest;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dao.SingerService;
import com.distribuida.dto.Singer;

@Path("/singer")
@ApplicationScoped
public class SingerRest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject private SingerService singerService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Singer> buscarTodos(){
		return singerService.findAll();	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Singer buscarID(@PathParam(value="id") Integer id){
		return singerService.findById(id);	
	}
	
}
