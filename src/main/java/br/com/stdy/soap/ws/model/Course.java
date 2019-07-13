package br.com.stdy.soap.ws.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name="COURSE")
public class Course {

	@Id
	private int id;
	private String name;
	private String description;
	
}
