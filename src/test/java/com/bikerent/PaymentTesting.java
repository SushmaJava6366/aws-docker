package com.bikerent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bikerent.dao.PaymentRepository;
import com.bikerent.entities.Payment;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PaymentTesting {

	@Mock
	PaymentRepository prepo;

	@Test
	@Order(1)
	public void testCreate() {
		Payment p = new Payment();
		p.setId(1);
		p.setCardno("3045-8987-3456");
		p.setNameoncard("karthik");
		p.setAmount(10000);
		p.setCvv(878);
		p.setPaymentmethod("debitcard");
		p.setExmonth(7);
		p.setExyear(2027);
		prepo.save(p);
		assertNotNull(prepo.findById(1).get());

	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<Payment> list = prepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void getSinglepayment() {
		Payment payment = prepo.findById(1).get();
		assertEquals(10000, payment.getAmount());

	}

}