package com.ssinitsa.training.culinary.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ssinitsa.training.culinary.dao.impl.db.IRecipeDao;
import com.ssinitsa.training.culinary.datamodel.Recipe;
import com.ssinitsa.training.culinary.services.IRecipeService;

@Service
public class RecipeServiceImpl implements IRecipeService {

	@Inject
	private IRecipeDao recipeDao;

	@Override
	public Recipe get(Integer id) {
		return recipeDao.get(id);
	}

	@Override
	public List<Recipe> getAll() {
		return recipeDao.getAll();
	}

	@Override
	public void save(Recipe recipe) {
		if (recipe.getId() == null) {
			System.out.println("Insert new Recipe");
			recipeDao.insert(recipe);
		} else {
			recipeDao.update(recipe);
		}
	}

	@Override
	public void delete(Integer id) {
		recipeDao.delete(id);

	}

	@Override
	public void saveMultiple(Recipe... recipeAray) {

		for (Recipe recipe : recipeAray) {
			save(recipe);
		}

	}
}
