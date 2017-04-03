package com.ssinitsa.training.culinary.dao.impl.db;

import java.util.List;

import com.ssinitsa.training.culinary.datamodel.DishCategories;

public interface IDishCategoriesDao {
	DishCategories get(Integer id);

	DishCategories insert(DishCategories dishCategories);

	void update(DishCategories dishCategories);

	List<DishCategories> getAll();

	void delete(Integer id);

}
