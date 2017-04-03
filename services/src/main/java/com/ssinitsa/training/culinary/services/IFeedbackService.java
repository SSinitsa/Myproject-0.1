package com.ssinitsa.training.culinary.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssinitsa.training.culinary.datamodel.Feedback;

public interface IFeedbackService {

	Feedback get(Integer id);

	@Transactional
	void save(Feedback feedback);

	@Transactional
	void saveMultiple(Feedback... recipe);

	List<Feedback> getAll();

	@Transactional
	void delete(Integer id);
}
