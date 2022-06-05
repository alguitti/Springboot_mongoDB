package com.andreguitti.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.andreguitti.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	//os métodos de acesso a dados já vem por herança
	
	//Query Methods do Spring com MongoDB
	@Query
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
