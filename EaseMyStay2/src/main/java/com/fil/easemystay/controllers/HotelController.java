package com.fil.easemystay.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fil.easemystay.entities.Hotel;
import com.fil.easemystay.service.HotelService;


@RequestMapping("api/v1/")
@Controller
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping("/home")
//	@ResponseBody
	public String home() {
		System.out.println("inside home controller");
		return "demo"; //when we don't write ResponseBody, we need to specify te
	}

	@GetMapping("/hotels")
	@ResponseBody
	public List<Hotel> getHotels() {
		System.out.println("inside get");
		return this.hotelService.getHotels();
	}

	@GetMapping("/hotel/{id}")
	public Hotel getHotel(@PathVariable int id) {
		return this.hotelService.getHotel(id);
	}

	@PostMapping("/hotel")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		System.out.println("inside post");
		return this.hotelService.addHotel(hotel);
	}

	@PutMapping("/hotel")
	public Hotel updateHotel(@RequestBody Hotel hotel) {
		return this.hotelService.updateHotel(hotel);
	}

	@DeleteMapping("/hotel/{hotel_id}")
	public ResponseEntity<HttpStatus> deleteHotel(@PathVariable int id) {
		try {
			this.hotelService.removeHotel(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}