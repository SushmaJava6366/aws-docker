package com.bikerent.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikerent.entities.Bike;
import com.bikerent.service.BikeService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/bk")
public class BikeController {

	@Autowired
	private BikeService bs;

	@PostMapping
	public ResponseEntity<Bike> add(@Valid @RequestBody  Bike bike) throws Exception{
		return new ResponseEntity<Bike>(bs.addBike(bike), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Bike> update(@Valid @RequestBody  Bike bike) {
		return new ResponseEntity<Bike>( bs.updateBike(bike),HttpStatus.CREATED);
	}

	@GetMapping
	public List<Bike> findAll() {
		return bs.listAll();
	}

	@GetMapping("filter/{id}")
	public ResponseEntity<Bike>getEmployeeById(@PathVariable("id")int id){
		Optional<Bike> bike=bs.retrieveOne(id);
		if(bike.isPresent()) {
			return new ResponseEntity<>(bike.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable int id) {
		bs.deleteBike(id);
	}

	@GetMapping("/page/{offset}/{pagesize}")
	public Page<Bike> getbypage(@PathVariable int offset, @PathVariable int pagesize) {
		return bs.listAllPage(offset, pagesize);
	}

}
