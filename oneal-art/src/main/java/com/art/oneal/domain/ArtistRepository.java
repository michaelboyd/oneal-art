package com.art.oneal.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	
	List <Artist> findByNameStartsWithIgnoreCase(@Param("name") String name);

}
