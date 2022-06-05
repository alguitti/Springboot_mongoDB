package com.andreguitti.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andreguitti.domain.Post;
import com.andreguitti.domain.User;
import com.andreguitti.dto.AuthorDTO;
import com.andreguitti.repositories.PostRepository;
import com.andreguitti.repositories.UserRepository;

//Classe para instanciar objetos para teste do projeto
//Método run roda o método ao inicio do programa
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
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou p SP vtnc", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "vtnc", "vtnc", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
