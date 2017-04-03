package com.ssinitsa.training.culinary.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ssinitsa.training.culinary.dao.impl.db.IRecipeDetailsDao;
import com.ssinitsa.training.culinary.datamodel.RecipeDetails;
import com.ssinitsa.training.culinary.services.IRecipeDetailsService;

@Service
public class RecipeDetailsServiceImpl implements IRecipeDetailsService {

	@Inject
	private IRecipeDetailsDao recipeDetailsDao;

	@Override
	public RecipeDetails get(Integer id) {
		return recipeDetailsDao.get(id);
	}

	@Override
	public List<RecipeDetails> getAll() {
		return recipeDetailsDao.getAll();
	}

	@Override
	public void save(RecipeDetails recipeDetails) {
		if (recipeDetails.getId() == null) {
			System.out.println("Insert new RecipeDetails");
			recipeDetailsDao.insert(recipeDetails);
		} else {
			recipeDetailsDao.update(recipeDetails);
		}
	}

	@Override
	public void delete(Integer id) {
		recipeDetailsDao.delete(id);

	}

	@Override
	public void saveMultiple(RecipeDetails... recipeDetailsAray) {

		for (RecipeDetails recipeDetails : recipeDetailsAray) {
			save(recipeDetails);
		}

	}
}
