package com.andreguitti.dto;

import java.io.Serializable;

import com.andreguitti.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 824469510548918719L;

	private String id;
	private String name;
	private String email;

	public UserDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public User fromDTO() {
		return new User(this.id, this.name, this.email);
	}

}
