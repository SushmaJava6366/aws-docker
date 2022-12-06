package com.bikerent.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int id;
	@NotNull
	@NotEmpty
	private String cardno;
	@NotNull
	@NotEmpty
	private String nameoncard;
	
	private LocalDate pmtdate;
	@NotNull
	private int amount;
	@NotEmpty
	private String paymentmethod;
	@NotNull
	private int cvv;
	@NotNull
	private int exmonth;
	private int exyear;

	public Payment() {
		super();
		this.pmtdate = LocalDate.now();

		// TODO Auto-generated constructor stub
	}

	public Payment(int id, String cardno, String nameoncard, LocalDate pmtdate, int amount, int exmonth, int exyear,
			String paymentmethod, int cvv) {
		super();
		this.id = id;
		this.cardno = cardno;
		this.nameoncard = nameoncard;
		this.pmtdate = pmtdate;
		this.amount = amount;
		this.paymentmethod = paymentmethod;
		this.cvv = cvv;
		this.exmonth = exmonth;
		this.exyear=exyear;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public LocalDate getPmtdate() {
		return pmtdate;
	}

	public void setPmtdate(LocalDate pmtdate) {
		this.pmtdate = pmtdate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getExmonth() {
		return exmonth;
	}

	public void setExmonth(int exmonth) {
		this.exmonth = exmonth;
	}

	public int getExyear() {
		return exyear;
	}

	public void setExyear(int exyear) {
		this.exyear = exyear;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", cardno=" + cardno + ", nameoncard=" + nameoncard + ", pmtdate=" + pmtdate
				+ ", amount=" + amount + ", paymentmethod=" + paymentmethod + ", cvv=" + cvv + ", exmonth=" + exmonth
				+ ", exyear=" + exyear + "]";
	}

}
