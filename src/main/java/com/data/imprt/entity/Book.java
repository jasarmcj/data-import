package com.data.imprt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author jasar
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Book implements Serializable {

	@Id
	@GeneratedValue
	private Long bookId;
	private String name;
	private String description;
	private String author;
	private String type;
	private Double price;
	private String isbn;
	
}
