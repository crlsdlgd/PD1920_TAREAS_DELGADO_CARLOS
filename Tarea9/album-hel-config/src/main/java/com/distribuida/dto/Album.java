package com.distribuida.dto;

import java.io.Serializable;
import java.util.Date;


public class Album implements Serializable{
	
private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String singerId;
	
	private String title;
	
	private Date releaseDate;
	
	private Integer version;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSingerId() {
		return singerId;
	}

	public void setSingerId(String singerId) {
		this.singerId = singerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
	
	
}
