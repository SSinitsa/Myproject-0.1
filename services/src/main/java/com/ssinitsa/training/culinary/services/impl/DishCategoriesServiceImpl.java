package com.ssinitsa.training.culinary.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ssinitsa.training.culinary.dao.impl.db.IDishCategoriesDao;
import com.ssinitsa.training.culinary.datamodel.DishCategories;
import com.ssinitsa.training.culinary.services.IDishCategoriesService;

@Service
public class DishCategoriesServiceImpl implements IDishCategoriesService {

	@Inject
	private IDishCategoriesDao dishCategoriesDao;

	@Override
	public DishCategories get(Integer id) {
		return dishCategoriesDao.get(id);
	}

	@Override
	public List<DishCategories> getAll() {
		return dishCategoriesDao.getAll();
	}

	@Override
	public void save(DishCategories dishCategories) {
		if (dishCategories.getId() == null) {
			System.out.println("Insert new DishCategories");
			dishCategoriesDao.insert(dishCategories);
		} else {
			dishCategoriesDao.update(dishCategories);
		}
	}

	@Override
	public void delete(Integer id) {
		dishCategoriesDao.delete(id);

	}

	@Override
	public void saveMultiple(DishCategories... dishCategoriesAray) {

		for (DishCategories dishCategories : dishCategoriesAray) {
			save(dishCategories);
		}

	}
}
