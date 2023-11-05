package com.fil.easemystay.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import org.springframework.stereotype.Repository;

import com.fil.easemystay.entities.Booking;



@Repository
public interface BookingDao  extends JpaRepository<Booking, Integer>{
	@Query("SELECT u FROM Booking u WHERE u.user_id in :userid")
	List<Booking> getAllBookings(@Param("userid") int user_id);

