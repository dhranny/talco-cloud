package com.example.data;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Ingredient;
public interface IngredientRepository extends CrudRepository<Ingredient, String>{

}
