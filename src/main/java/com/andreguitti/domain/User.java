package com.andreguitti.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.andreguitti.dto.UserDTO;

@Document (collection = "user") //diz que corresponde à uma coleção do Mongo
public class User implements Serializable{
	private static final long serialVersionUID = 8478407511680095749L;
	
	@Id
	private String id;
	private String name;
	private String email;
	
	public User() { }

	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public UserDTO toDTO() {
		return new UserDTO(this.id, this.name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
