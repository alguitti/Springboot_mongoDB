package com.andreguitti.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreguitti.domain.Post;
import com.andreguitti.repositories.PostRepository;
import com.andreguitti.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired //instanciação e injeção de dependencias automática
	private PostRepository rep;
	
	public List<Post> findAll() {
		return rep.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> opt = rep.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("Post could not be found"));
	}
	
	//Query Methods
	public List<Post> findByTitle(String text) {
		return rep.findByTitleContainingIgnoreCase(text);
	}
	
	//@Query query method
	public List<Post> searchTitle(String text) {
		return rep.searchTitle(text);
	}
	
	//@Query com varios criterios
	public List<Post> fullSearch(String text, Date min, Date max) {
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return rep.fullSearch(text, min, max);
	}
}
