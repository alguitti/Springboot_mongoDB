package com.andreguitti.services;

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
	
	public List<Post> findByTitle(String text) {
		return rep.findByTitleContainingIgnoreCase(text);
	}
	
}
