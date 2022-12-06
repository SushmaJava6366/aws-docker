package com.bikerent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bikerent.dao.Dao;
import com.bikerent.entities.UserLogin;

@Service
public class UserService {
	@Autowired
	private Dao dao;

	public UserLogin register(UserLogin login) {
		return dao.save(login);
	}

	public UserLogin fetchfindBygmail(String gmail) {
		return dao.findByGmail(gmail);

	}

	public UserLogin fetchfindBygmailangpass(String gmail, String password) {
		return dao.findByGmailAndPassword(gmail, password);
	}

	public List<UserLogin> findAllUsers() {
		return dao.findAll(Sort.by(Direction.DESC, "id"));
	}

}