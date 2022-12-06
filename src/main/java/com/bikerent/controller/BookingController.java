package com.bikerent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.bikerent.entities.Booking;
import com.bikerent.service.BookingService;

@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:4200")
public class BookingController {

	@Autowired
	public BookingService bservice;

	@PostMapping
	public Booking addBooking(@Valid @RequestBody Booking booking) {
		return bservice.addBooking(booking);
	}

	@GetMapping("getBy/{id}")
	public Booking getAllBooking(@PathVariable int id) {
		return bservice.getAllBookings(id);

	}

	@GetMapping
	public ResponseEntity<?> findAllBookings() {
		return ResponseEntity.ok(bservice.findAllBookings());
	}

	@DeleteMapping("deleteBy/{id}")
	public void deleteBooking(@PathVariable int id) {
		bservice.deleteBooking(id);

	}

	@PutMapping("updateBy/{id}")
	public Booking UpdateBooking(@Valid @RequestBody Booking booking) {
		return bservice.updateBooking(booking);

	}

	@GetMapping("/page/{offset}/{pagesize}")
	public Page<Booking> getBookingsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pagesize) {
		return bservice.findBookingsWithPagination(offset, pagesize);
	}

}