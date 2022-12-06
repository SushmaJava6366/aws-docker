package com.bikerent.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bike")
public class Bike {

	@Id
	@Column(name = "bike_id")
	private int id;
	@NotNull
	@NotEmpty
	private String bikenum;
	@NotNull
	@NotEmpty
	private String bikename;
	@NotNull
	@NotEmpty
	private String bikevar;
	@Column(nullable = false)
	private int modelyear;
	@NotNull
	private String status;
	private LocalDate createdon;
	@NotNull
	private int price;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_bike_id", referencedColumnName = "bike_id")
	private List<Booking> booking;

	public Bike() {
		super();
		this.createdon = LocalDate.now();
	}

	public Bike(int id, String bikenum, String bikename, String bikevar, int modelyear, String status,
			LocalDate createdon, int price) {
		super();
		this.id = id;
		this.bikenum = bikenum;
		this.bikename = bikename;
		this.bikevar = bikevar;
		this.modelyear = modelyear;
		this.status = status;
		this.createdon = createdon;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBikenum() {
		return bikenum;
	}

	public void setBikenum(String bikenum) {
		this.bikenum = bikenum;
	}

	public String getBikename() {
		return bikename;
	}

	public void setBikename(String bikename) {
		this.bikename = bikename;
	}

	public String getBikevar() {
		return bikevar;
	}

	public void setBikevar(String bikevar) {
		this.bikevar = bikevar;
	}

	public int getModelyear() {
		return modelyear;
	}

	public void setModelyear(int modelyear) {
		this.modelyear = modelyear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDate createdon) {
		this.createdon = createdon;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", bikenum=" + bikenum + ", bikename=" + bikename + ", bikevar=" + bikevar
				+ ", modelyear=" + modelyear + ", status=" + status + ", createdon=" + createdon + ", price=" + price
				+ "]";
	}

}
