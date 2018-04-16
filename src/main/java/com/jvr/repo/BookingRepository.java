package com.jvr.repo;

import org.springframework.data.repository.CrudRepository;

import com.jvr.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {

}
