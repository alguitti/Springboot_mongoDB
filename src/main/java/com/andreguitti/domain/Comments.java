package com.andreguitti.domain;

import java.io.Serializable;
import java.util.Date;

import com.andreguitti.dto.AuthorDTO;

public class Comments implements Serializable{
	private static final long serialVersionUID = 283495770646772064L;

	private String text;
	private Date date;
	private AuthorDTO author;
	
	public Comments() { }

	public Comments(String text, Date date, AuthorDTO author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
}
