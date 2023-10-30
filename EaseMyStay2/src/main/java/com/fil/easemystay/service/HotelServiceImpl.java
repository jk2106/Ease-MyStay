package com.fil.easemystay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	}
}
