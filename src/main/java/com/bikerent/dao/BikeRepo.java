package com.bikerent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikerent.entities.Bike;

@Repository
public interface BikeRepo extends JpaRepository<Bike, Integer> {
	public List<Bike> findByStatus(String status);

	public Bike findByBikenum(String bikenum);
}
