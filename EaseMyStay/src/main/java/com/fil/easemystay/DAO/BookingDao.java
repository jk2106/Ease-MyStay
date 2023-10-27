package com.fil.easemystay.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fil.easemystay.entities.Booking;

@Repository
public interface BookingDao  extends JpaRepository<Booking, Integer>{

}
