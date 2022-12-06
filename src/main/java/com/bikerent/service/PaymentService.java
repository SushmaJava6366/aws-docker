package com.bikerent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bikerent.dao.PaymentRepository;
import com.bikerent.entities.Payment;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository prepo;

	public void addPayment(Payment payment) {
		prepo.save(payment);
	}

	public Payment getAllPayments(int id) {
		return prepo.findById(id).get();
	}

	public List<Payment> findAllPayments() {
		return prepo.findAll(Sort.by(Direction.DESC, "id"));
	}

}
