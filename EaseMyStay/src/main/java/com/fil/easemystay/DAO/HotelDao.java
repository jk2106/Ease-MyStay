package com.fil.easemystay.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fil.easemystay.entities.Hotel;

@Repository
	public interface HotelDao  extends JpaRepository<Hotel, Integer>{
		@Query("SELECT u FROM Hotel u WHERE u.city = :inputname")
		List<Hotel> findByname(@Param("inputname") String city);
	}

