package com.bikerent.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Booking")
public class Booking {
	@Id
	@Column(name = "booking_id")
	private int id;
	@NotNull
	@Size(min = 2, message = "name have atleast 2 charactor")
	@NotEmpty
	private String bikename;
	@NotEmpty
	@NotNull
	private String bikenum;
	@NotNull

	private String fromdate;
	@NotNull

	private String todate;
	@NotNull
	@Size(min = 2, message = "name have atleast 2 charactor")
	@NotEmpty
	private String uname;
	@NotNull
	@NotEmpty
	private String phone;
	@NotNull

	private String gender;
	@NotNull
	private int advanceamount;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_payment_id")
	private Payment payment;

	public Booking() {
		super();

	}

	public Booking(int id, String bikename, String bikenum, String fromdate, String todate, String uname, String phone,
			String gender, int advanceamount, Payment payment) {
		super();
		this.id = id;
		this.bikename = bikename;
		this.bikenum = bikenum;
		this.fromdate = fromdate;
		this.todate = todate;
		this.uname = uname;
		this.phone = phone;
		this.gender = gender;
		this.advanceamount = advanceamount;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBikename() {
		return bikename;
	}

	public void setBikename(String bikename) {
		this.bikename = bikename;
	}

	public String getBikenum() {
		return bikenum;
	}

	public void setBikenum(String bikenum) {
		this.bikenum = bikenum;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAdvanceamount() {
		return advanceamount;
	}

	public void setAdvanceamount(int advanceamount) {
		this.advanceamount = advanceamount;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bikename=" + bikename + ", bikenum=" + bikenum + ", fromdate=" + fromdate
				+ ", todate=" + todate + ", uname=" + uname + ", phone=" + phone + ", gender=" + gender
				+ ", advanceamount=" + advanceamount + ", payment=" + payment + "]";
	}

}
