package com.bikerent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikerent.entities.Payment;
import com.bikerent.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("http://localhost:4200")
public class PaymentController {
	@Autowired
	PaymentService pservice;

	@PostMapping
	public void addPayment(@Valid @RequestBody Payment payment) {
		pservice.addPayment(payment);
	}

	@GetMapping("getBy/{id}")
	public Payment getAllPayments(@PathVariable int id) {
		return pservice.getAllPayments(id);

	}

	@GetMapping
	public List<Payment> findAllPayments() {
		return pservice.findAllPayments();

	}

}