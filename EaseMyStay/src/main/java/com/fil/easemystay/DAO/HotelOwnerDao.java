package com.fil.easemystay.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fil.easemystay.entities.HotelOwner;

@Repository
public interface HotelOwnerDao  extends JpaRepository<HotelOwner, Integer>{

}
