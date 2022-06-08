package com.andreguitti.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.andreguitti.dto.AuthorDTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Post implements Serializable {
	private static final long serialVersionUID = -6177859869475731512L;
	
	@Id
	@Getter @Setter
	private String id;
	@Getter @Setter
	private Date date;
	@Getter @Setter
	private String title;
	@Getter @Setter
	private String body;
	@Getter @Setter
	private AuthorDTO author;
	@Getter
	private List<Comments> comments = new ArrayList<>();

	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}

}
