package com.distribuida.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path(value="/")
public class PingRest {

	@GET
	@Path("/ping")
	public String ping() {
		System.out.println("ping");
		return "ok";
	}
	
}
