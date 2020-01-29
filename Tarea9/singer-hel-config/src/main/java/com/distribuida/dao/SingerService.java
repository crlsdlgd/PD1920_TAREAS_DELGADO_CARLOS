package com.distribuida.dao;

import java.util.List;

import com.distribuida.dto.Singer;

public interface SingerService {

	
	/*Singer create(Singer singer);
	
	Singer update(Singer singer);
	void delete(Integer id);
	
	
	*/
	List<Singer> findAll();
	Singer findById(Integer id);
	
	
	
}
