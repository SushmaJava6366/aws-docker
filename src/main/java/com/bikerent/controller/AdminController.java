package com.bikerent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikerent.entities.Admin;
import com.bikerent.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService adminservice;


	@PostMapping("/login")
	public Admin login(@RequestBody Admin admin) throws Exception {
		adminservice.reg();

		String A = admin.getAdminId();
		String B = admin.getPassword();
		Admin obj = null;
		if (A != null && B != null) {
			obj = adminservice.fetchByAdminIdAndPassword(A, B);

		}
		if (obj == null) {
			throw new Exception("please enter the valid Credentials");
		}
		return obj;
	}

}