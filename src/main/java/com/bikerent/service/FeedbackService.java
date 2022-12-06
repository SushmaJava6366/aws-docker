package com.bikerent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.bikerent.dao.FeedbackRepository;
import com.bikerent.entities.Feedback;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepository prepo;

	public Feedback addFeedback(Feedback fb) {
		return prepo.save(fb);
	}

	public List<Feedback> listAll() {

		return prepo.findAll(Sort.by(Direction.ASC, "name"));
	}

	public void deletereview(int id) {
		Feedback review = prepo.findById(id).get();
		prepo.delete(review);
	}
}