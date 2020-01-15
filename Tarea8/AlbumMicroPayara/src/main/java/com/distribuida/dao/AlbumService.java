package com.distribuida.dao;

import java.util.List;

import com.distribuida.dto.Album;

public interface AlbumService {

	
	/*Singer create(Singer singer);
	
	Singer update(Singer singer);
	void delete(Integer id);
	
	
	*/
	List<Album> findAll();
	Album findById(Integer id);
	
	
	
}
