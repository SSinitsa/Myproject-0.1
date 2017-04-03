package com.ssinitsa.training.culinary.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssinitsa.training.culinary.datamodel.RecipeDetails;

public interface IRecipeDetailsService {

	RecipeDetails get(Integer id);

	@Transactional
	void save(RecipeDetails recipeDetails);

	@Transactional
	void saveMultiple(RecipeDetails... recipeDetails);

	List<RecipeDetails> getAll();

	@Transactional
	void delete(Integer id);
}
