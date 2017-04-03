package com.ssinitsa.training.culinary.dao.impl.db;

import java.util.List;

import com.ssinitsa.training.culinary.datamodel.Feedback;

public interface IFeedbackDao {
	Feedback get(Integer id);

	Feedback insert(Feedback feedback);

	void update(Feedback feedback);

	List<Feedback> getAll();

	void delete(Integer id);

}
