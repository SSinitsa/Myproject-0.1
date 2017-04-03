package com.ssinitsa.training.culinary.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssinitsa.training.culinary.datamodel.Recipe;

public interface IRecipeService {

	Recipe get(Integer id);

	@Transactional
	void save(Recipe recipe);

	@Transactional
	void saveMultiple(Recipe... recipe);

	List<Recipe> getAll();

	@Transactional
	void delete(Integer id);
}
