package com.bikerent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerent.dao.AdminDao;
import com.bikerent.entities.Admin;

@Service
public class AdminService {
	@Autowired
	private AdminDao admindao;

	public void reg() {
		Admin admin = new Admin();
		admin.setAdminId("Sarath123");
		admin.setPassword("SARath@81");
		admin.setAdminname("Sarathkumar");
		admindao.save(admin);

	}

	public Admin Register(Admin admin) {
		return admindao.save(admin);

	}

	public Admin fetchByAdminIdAndPassword(String adminId, String password) {
		return admindao.findByAdminIdAndPassword(adminId, password);

	}

}