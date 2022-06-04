package com.andreguitti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreguitti.domain.Post;
import com.andreguitti.repositories.PostRepository;

@Service
public class PostService {

	@Autowired //instanciação e injeção de dependencias automática
	private PostRepository rep;
	
	public List<Post> findAll() {
		return rep.findAll();
	}
	
}
