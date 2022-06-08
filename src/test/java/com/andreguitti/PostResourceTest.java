package com.andreguitti;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.andreguitti.domain.Post;
import com.andreguitti.services.PostService;

@SpringBootTest


public class PostResourceTest {

	@Autowired
	private PostService service;
	
	@Test
	public void testRequestDB() {
		
		boolean test = false;
		
		List<Post> posts = service.findAll();
		if (posts.size() > 0) {
			test = true;
		}
		System.out.println(test);
		assertThat(test, is(true));
		
	}
	
}
