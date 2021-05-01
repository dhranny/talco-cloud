package com.example.models;
import java.util.ArrayList;
import com.example.models.Ingredient.Type;
import java.util.Iterator;
public class IngredientList<E> extends ArrayList{

	public ArrayList filterByType(String type) {
		Iterator<Ingredient> iterator = iterator();
		ArrayList<Ingredient> filteredList = new ArrayList<Ingredient>();
		for(Ingredient ingredient = iterator.next();iterator.hasNext();iterator.next()) {
			if(ingredient.getType() == type) {
				filteredList.add(ingredient);
			}
		}
		return filteredList;
	}
}
