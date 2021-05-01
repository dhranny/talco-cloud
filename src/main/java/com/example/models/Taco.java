package com.example.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Taco {

	private String name;
	@Id
	private long id;
	private Date createdAt;
	@ManyToMany(targetEntity = Ingredient.class)
	private List<Ingredient> ingredients;
}
