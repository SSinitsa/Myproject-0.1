package com.ssinitsa.training.culinary.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssinitsa.training.culinary.datamodel.DishCategories;

public interface IDishCategoriesService {

	DishCategories get(Integer id);

	@Transactional
	void save(DishCategories dishCategories);

	@Transactional
	void saveMultiple(DishCategories... dishCategories);

	List<DishCategories> getAll();

	@Transactional
	void delete(Integer id);
}
