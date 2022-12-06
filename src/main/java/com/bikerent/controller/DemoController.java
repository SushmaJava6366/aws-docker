package com.bikerent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikerent.entities.UserLogin;
import com.bikerent.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class DemoController {
	@Autowired
	private UserService user;

	@PostMapping("/register")
	public UserLogin Create(@Valid @RequestBody UserLogin login) throws Exception {
		String tempGmail = login.getGmail();
		if (tempGmail != null && !"".equals(tempGmail)) {
			UserLogin obj = user.fetchfindBygmail(tempGmail);
			if (obj != null) {
				throw new Exception("this Email already Exists" + tempGmail);
			}

		}

		return user.register(login);

	}

	@PostMapping("/log")
	public UserLogin Login(@RequestBody UserLogin login) throws Exception {

		String tempgmail = login.getGmail();
		String temppass = login.getPassword();
		UserLogin obj = null;
		if (tempgmail != null && temppass != null) {
			obj = user.fetchfindBygmailangpass(tempgmail, temppass);

		}
		if (obj == null) {
			throw new Exception("bad Crentrentials pls Enter correct value");
		}
		return obj;

	}

	@GetMapping("/getuser")
	public List<UserLogin> findAllUsers() {
		return user.findAllUsers();

	}

}