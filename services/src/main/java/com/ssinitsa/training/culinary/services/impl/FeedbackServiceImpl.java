package com.ssinitsa.training.culinary.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ssinitsa.training.culinary.dao.impl.db.IFeedbackDao;
import com.ssinitsa.training.culinary.datamodel.Feedback;
import com.ssinitsa.training.culinary.services.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Inject
	private IFeedbackDao feedbackDao;

	@Override
	public Feedback get(Integer id) {
		return feedbackDao.get(id);
	}

	@Override
	public List<Feedback> getAll() {
		return feedbackDao.getAll();
	}

	@Override
	public void save(Feedback feedback) {
		if (feedback.getId() == null) {
			System.out.println("Insert new Feedback");
			feedbackDao.insert(feedback);
		} else {
			feedbackDao.update(feedback);
		}
	}

	@Override
	public void delete(Integer id) {
		feedbackDao.delete(id);

	}

	@Override
	public void saveMultiple(Feedback... feedbackAray) {

		for (Feedback feedback : feedbackAray) {
			save(feedback);
		}

	}
}
