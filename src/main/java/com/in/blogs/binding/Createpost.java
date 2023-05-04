package com.in.blogs.binding;

import java.time.LocalDate;

import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class Createpost {

	private String title;
	private String description;
	@Lob
	private String content;
	}
