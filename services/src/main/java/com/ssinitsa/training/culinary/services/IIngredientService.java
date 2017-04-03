package com.ssinitsa.training.culinary.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssinitsa.training.culinary.datamodel.Ingredient;

public interface IIngredientService {

	Ingredient get(Integer id);

	@Transactional
	void save(Ingredient ingredient);

	@Transactional
	void saveMultiple(Ingredient... ingredient);

	List<Ingredient> getAll();

	@Transactional
	void delete(Integer id);
}
