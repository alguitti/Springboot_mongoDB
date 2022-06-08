package com.andreguitti.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andreguitti.domain.Comments;
import com.andreguitti.domain.Post;
import com.andreguitti.domain.User;
import com.andreguitti.dto.AuthorDTO;
import com.andreguitti.repositories.PostRepository;
import com.andreguitti.repositories.UserRepository;

/**
 * Classe para instanciar objetos a fim de checar o funcionamento da aplicação
 * 
 * @author andre
 */

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();

		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User andre = new User(null, "André", "andre@yahoo.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob, andre));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "aaaaa", "bbbbb", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "ccccc", "ddddd", new AuthorDTO(maria));

		Comments c1 = new Comments("Boa viagem", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		Comments c2 = new Comments("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		Comments c3 = new Comments("Good day", sdf.parse("23/03/2018"), new AuthorDTO(alex));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

}
