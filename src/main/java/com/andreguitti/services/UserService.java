package com.andreguitti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreguitti.domain.User;
import com.andreguitti.repositories.UserRepository;

@Service
public class UserService {

	@Autowired //instanciação e injeção de dependencias automática
	private UserRepository rep;
	
	public List<User> findAll() {
		return rep.findAll();
	}
	
}
