package com.ssinitsa.training.culinary.dao.impl.db;

import java.util.List;

import com.ssinitsa.training.culinary.datamodel.RecipeDetails;

public interface IRecipeDetailsDao {
	RecipeDetails get(Integer id);

	RecipeDetails insert(RecipeDetails recipeDetails);

	void update(RecipeDetails recipeDetails);

	List<RecipeDetails> getAll();

	void delete(Integer id);

}
