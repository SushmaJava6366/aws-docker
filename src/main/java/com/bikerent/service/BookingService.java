package com.bikerent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bikerent.dao.BookingRepository;
import com.bikerent.entities.Booking;

@Service
public class BookingService {
	@Autowired
	public BookingRepository repo;

	public Booking addBooking(Booking booking) {
		return repo.save(booking);
	}

	public Booking updateBooking(Booking booking) {
		return repo.save(booking);

	}

	public void deleteBooking(int id) {
		repo.deleteById(id);

	}

	public Booking getAllBookings(int id) {
		return repo.findById(id).get();
	}

	public List<Booking> findAllBookings() {
		return repo.findAll(Sort.by(Direction.DESC, "id"));
	}

	public List<Booking> findBookingsWithSorting(String field) {
		return repo.findAll(Sort.by(Sort.Direction.ASC, field));

	}

	public Page<Booking> findBookingsWithPagination(int offset, int pageSize) {
		Page<Booking> bookings = repo.findAll(PageRequest.of(offset, pageSize));
		return bookings;
	}

}
