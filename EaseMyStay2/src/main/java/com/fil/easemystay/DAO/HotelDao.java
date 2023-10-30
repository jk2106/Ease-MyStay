package com.fil.easemystay.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fil.easemystay.entities.Hotel;

@Repository

public interface HotelDao  extends JpaRepository<Hotel, Integer>{
}
