
package com.bikerent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikerent.entities.UserLogin;

@Repository
public interface Dao extends JpaRepository<UserLogin, Integer> {
	public UserLogin findByGmail(String gmail);

	public UserLogin findByGmailAndPassword(String gmail, String password);

}
