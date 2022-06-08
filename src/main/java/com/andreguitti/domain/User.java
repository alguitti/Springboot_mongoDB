package com.andreguitti.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.andreguitti.dto.UserDTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Document (collection = "user") << para criação do documento no MongoDB
 * @DBRef(lazy = true) << lista de referências para os posts com lazy loading
 * 
 * @author andre
 *
 */

@Document (collection = "user")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class User implements Serializable{
	private static final long serialVersionUID = 8478407511680095749L;
	
	@Id
	@Getter @Setter
	private String id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String email;
	@DBRef(lazy = true)
	@Getter
	private List<Post> posts = new ArrayList<>();

	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public UserDTO toDTO() {
		return new UserDTO(this.id, this.name);
	}
	
}
