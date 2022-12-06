package com.bikerent.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "userlogin")
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@NotNull
	@NotEmpty
	private String name;
	@Email
	@NotEmpty
	private String gmail;
	@NotNull
	@NotEmpty
	private String password;
	private String pnumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_booking_id")
	private Booking booking;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "user_id")
	private List<Feedback> feedback;

	public UserLogin() {
		super();
	}

	public UserLogin(int id, String name, String gmail, String password, String pnumber) {
		super();
		this.id = id;
		this.name = name;
		this.gmail = gmail;
		this.password = password;
		this.pnumber = pnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}


	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

}