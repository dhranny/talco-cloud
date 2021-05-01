package com.example.controller;
import com.example.data.IngredientRepository;
import com.example.data.TacoRepo;
import com.example.models.Ingredient;
import com.example.models.IngredientList;
import com.example.models.Order;
import com.example.models.Ingredient.Type;
import com.example.models.Taco;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
@Slf4j
public class DesignController {
	
	private final IngredientRepository ingrRepo;
	private TacoRepo tacoRepo;
	
	@ModelAttribute(name = "order")
	public Order order() {
	return new Order();
	}
	
	@ModelAttribute(name = "taco")
	public Taco taco() {
	return new Taco();
	}
	public DesignController(IngredientRepository ingrRepo, TacoRepo tacoRepo) {
		this.tacoRepo  = tacoRepo;
		this.ingrRepo = ingrRepo;
	}
	@GetMapping
	public String showDesignView(Model model) {
		Iterable<Ingredient> ingredients = ingrRepo.findAll();
		Type[] types = Type.values();
		for(Type ingredientType: types) {
			model.addAttribute(ingredientType.toString(), filterByType(ingredients, ingredientType));
		}
		model.addAttribute("design", new Taco());
		return "design";
	}
	
	public List<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
		List listToReturn = new ArrayList<Ingredient>();
		for(Ingredient ingredient: ingredients) {
			if(ingredient.getType().equals(type))
				log.info("xetfgt");
				listToReturn.add(ingredient);
		}
		return listToReturn;
	}
	
	@PostMapping
	public String postMapping(Taco taco, Errors errors, @ModelAttribute Order order) {
		if(errors.hasErrors()) {
			return("design");
		}
		Taco saved = tacoRepo.save(taco);
		return "redirect:/orders/current";
	}
}
