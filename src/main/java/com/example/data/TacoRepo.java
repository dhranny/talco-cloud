package com.example.data;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Taco;

public interface TacoRepo extends CrudRepository<Taco, Long>{

	Taco save(Taco taco);
}
