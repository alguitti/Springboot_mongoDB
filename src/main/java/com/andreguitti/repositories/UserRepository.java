package com.andreguitti.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andreguitti.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
		
}
