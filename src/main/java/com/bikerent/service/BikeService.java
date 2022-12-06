package com.bikerent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bikerent.dao.BikeRepo;
import com.bikerent.entities.Bike;

@Service
public class BikeService {
	@Autowired
	private BikeRepo br;

	public Bike addBike(Bike bike) throws Exception {
		String tempbikenum = bike.getBikenum();
		if (tempbikenum != null && !"".equals(tempbikenum)) {
			Bike obj = br.findByBikenum(tempbikenum);
			if (obj != null) {
				throw new Exception("This Bike Number is already enrolled");
			}
		}
		return br.save(bike);
	}

	public Bike updateBike(Bike bike) {
		return br.save(bike);
	}

	public List<Bike> listAll() {
		return br.findAll(Sort.by(Direction.ASC, "id"));
	}

	public List<Bike> filterBikes(int id) {
		if (id == 1)
			return br.findByStatus("Available");
		else
			return br.findByStatus("Not Available");
	}

	//public Bike getBike(int id) {
		//return br.findById(id).get();
	//}
	public Optional<Bike> retrieveOne(int id){
		return br.findById(id);
	}

	public void deleteBike(int id) {
		Bike bike = br.findById(id).get();
		br.delete(bike);
	}

	public Page<Bike> listAllPage(int offset, int pagesize) {
		Page<Bike> bikes = br.findAll(PageRequest.of(offset, pagesize));
		return bikes;
	}

	public Bike samebikenum(String bikenum) {
		return br.findByBikenum(bikenum);
	}

}
