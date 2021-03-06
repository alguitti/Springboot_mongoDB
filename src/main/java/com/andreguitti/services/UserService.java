package com.andreguitti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreguitti.domain.User;
import com.andreguitti.repositories.UserRepository;
import com.andreguitti.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired //instanciação e injeção de dependencias automática
	private UserRepository rep;
	
	public List<User> findAll() {
		return rep.findAll();
	}
	
	public User findById(String id) {
		Optional<User> optUser = rep.findById(id);
		return optUser.orElseThrow(() -> new ObjectNotFoundException("Id doesn't exist"));
	}
	
	public User insert(User user) {
		return rep.insert(user);
	}
	
	public void delete(String id) {
		User user = findById(id);
		rep.delete(user);
	}
	
	public User update(User obj) {
		User newUser = findById(obj.getId());
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());
		return rep.save(newUser);
	}
	
}
