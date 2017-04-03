package com.ssinitsa.training.culinary.dao.impl.db;

import java.util.List;

import com.ssinitsa.training.culinary.datamodel.Ingredient;

public interface IIngredientDao {

	Ingredient get(Integer id);

	Ingredient insert(Ingredient ingredient);

	void update(Ingredient ingredient);

	List<Ingredient> getAll();

	void delete(Integer id);

}
