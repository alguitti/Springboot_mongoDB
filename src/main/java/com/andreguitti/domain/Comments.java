package com.andreguitti.domain;

import java.io.Serializable;
import java.util.Date;

import com.andreguitti.dto.AuthorDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comments implements Serializable {
	private static final long serialVersionUID = 283495770646772064L;
	
	private String text;
	private Date date;
	private AuthorDTO author;

}
