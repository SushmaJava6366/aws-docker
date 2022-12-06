package com.bikerent.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Feedback {

	@Id
	@Column(name = "feedback_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@Column(name = "name")
	private String name;
	@NotNull
	private int ratings;
	@NotNull
	@NotEmpty
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@Column(name = "reviews")
	private String reviews;
	@NotEmpty
	private String bikeNum;
	@NotEmpty
	private String bikeName;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int id, String name, int ratings, String reviews, String bikeNum, String bikeName) {
		super();
		this.id = id;
		this.name = name;
		this.ratings = ratings;
		this.reviews = reviews;
		this.bikeNum = bikeNum;
		this.bikeName = bikeName;
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

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getBikeNum() {
		return bikeNum;
	}

	public void setBikeNum(String bikeNum) {
		this.bikeNum = bikeNum;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + name + ", ratings=" + ratings + ", reviews=" + reviews + ", bikeNum="
				+ bikeNum + ", bikeName=" + bikeName + "]";
	}

}
