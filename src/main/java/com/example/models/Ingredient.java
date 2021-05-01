package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Ingredient {

	public final String name;
	@Id
	public final String id;
	public final String type;
	
	public static enum Type{
		WRAP, CHEESE, VEGGIES, PROTEIN, SAUCE
	}
}
