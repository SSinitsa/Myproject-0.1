package com.ssinitsa.training.culinary.dao.impl.db;

import java.util.List;

import com.ssinitsa.training.culinary.datamodel.Recipe;

public interface IRecipeDao {

	Recipe get(Integer id);

	Recipe insert(Recipe recipe);

	void update(Recipe recipe);

	List<Recipe> getAll();

	void delete(Integer id);

}
