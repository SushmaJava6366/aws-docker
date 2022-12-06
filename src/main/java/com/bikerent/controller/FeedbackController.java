package com.bikerent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bikerent.entities.Feedback;
import com.bikerent.service.FeedbackService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/addfeedback")
public class FeedbackController {
	@Autowired
	FeedbackService fbservice;

	@PostMapping
	public Feedback addFeedback(@Valid @RequestBody Feedback fb) {
		return fbservice.addFeedback(fb);
	}

	@GetMapping
	public List<Feedback> findAll() {
		return fbservice.listAll();
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable int id) {
		fbservice.deletereview(id);
	}
}
