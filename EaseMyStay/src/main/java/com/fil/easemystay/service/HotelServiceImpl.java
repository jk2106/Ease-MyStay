package com.fil.easemystay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fil.easemystay.DAO.HotelDao;
import com.fil.easemystay.entities.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDao hoteldao;

	@Override
	public List<Hotel> getHotels() {
		System.out.println("Getting hotels");
		return hoteldao.findAll();
		// TODO Auto-generated method stub

	}

	public Hotel getHotel(int id) {
		return hoteldao.findById(id).get();
	}

	public Hotel addHotel(Hotel hotel) {
		hoteldao.save(hotel);
		return hotel;
	}

	public Hotel updateHotel(Hotel hotel) {
		hoteldao.save(hotel);
		return hotel;
	}

	public void removeHotel(int id) {
		
			hoteldao.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.OK);
		
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}