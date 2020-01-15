package com.distribuida.rest;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dao.AlbumService;
import com.distribuida.dto.Album;

@Path("/album")
public class AlbumRest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject private AlbumService albumService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> buscarTodos(){
		return albumService.findAll();	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Album buscarID(@PathParam(value="id") Integer id){
		return albumService.findById(id);	
	}
	
	
	
}
