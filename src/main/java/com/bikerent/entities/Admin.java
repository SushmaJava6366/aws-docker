package com.bikerent.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Admin")
public class Admin {
	@Id
	@NotNull
	@NotEmpty
	@Column(name = "admin_id")
	private String adminId;
	@NotNull
	@NotEmpty
	private String password;
	@NotNull
	@NotEmpty
	private String adminname;

	public Admin() {
		super();
	}

	public Admin(String adminId, String password, String adminname) {
		super();
		this.adminId = adminId;
		this.password = password;
		this.adminname = adminname;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

}