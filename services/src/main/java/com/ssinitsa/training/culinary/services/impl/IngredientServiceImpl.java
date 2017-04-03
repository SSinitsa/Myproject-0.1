package com.ssinitsa.training.culinary.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ssinitsa.training.culinary.dao.impl.db.IIngredientDao;
import com.ssinitsa.training.culinary.datamodel.Ingredient;
import com.ssinitsa.training.culinary.services.IIngredientService;

@Service
public class IngredientServiceImpl implements IIngredientService {

	@Inject
	private IIngredientDao ingredientDao;

	@Override
	public Ingredient get(Integer id) {
		return ingredientDao.get(id);
	}

	@Override
	public List<Ingredient> getAll() {
		return ingredientDao.getAll();
	}

	@Override
	public void save(Ingredient ingredient) {
		if (ingredient.getId() == null) {
			System.out.println("Insert new Ingredient");
			ingredientDao.insert(ingredient);
		} else {
			ingredientDao.update(ingredient);
		}
	}

	@Override
	public void delete(Integer id) {
		ingredientDao.delete(id);

	}

	@Override
	public void saveMultiple(Ingredient... ingredientAray) {

		for (Ingredient ingredient : ingredientAray) {
			save(ingredient);
		}

	}
}
