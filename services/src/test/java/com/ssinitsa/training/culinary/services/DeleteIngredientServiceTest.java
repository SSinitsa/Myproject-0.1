package com.ssinitsa.training.culinary.services;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.ssinitsa.training.culinary.datamodel.Ingredient;

public class DeleteIngredientServiceTest extends AbstractTest {

	@Inject
	private IIngredientService service;

	private Integer savedIngredientId;
	private Ingredient ingredientFromDb;

	@Before
	public void createTest() {
		Ingredient ingredient = new Ingredient();
		ingredient.setName("new ingredient from java");
		ingredient.setCalories(1);
		ingredient.setFats(0.2);
		ingredient.setProteins(0.3);
		ingredient.setCarbohydrates(0.4);
		ingredient.setCategory("new category");
		service.save(ingredient);
		savedIngredientId = ingredient.getId();
		ingredientFromDb = service.get(savedIngredientId);

	}

	@Test
	public void deleteTest() {
		service.delete(savedIngredientId);

		Assert.isNull(ingredientFromDb, "ingredient must not exist");
	}
}
