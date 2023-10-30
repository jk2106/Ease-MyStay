package com.fil.easemystay.controller;

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
import com.fil.easemystay.entities.HotelOwner;
import com.fil.easemystay.service.HotelOwnerService;

@RequestMapping("api/v1/")
@RestController
public class HotelOwnerController {

	@Autowired
	private HotelOwnerService hotelOwnerService;


	@GetMapping("/homeOwner")
//	@ResponseBody
	public String home() {
		System.out.println("inside HotelOwner home controller");
		return "index"; //when we don't write ResponseBody, we need to specify te
	}

	@GetMapping("/hotelOwners")
	public List<HotelOwner> getHotelOwners() {
		System.out.println("inside get");
		return this.hotelOwnerService.getHotelOwners();
	}

	@GetMapping("/hotelOwner/{id}")
	public HotelOwner getHotel(@PathVariable int id) {
		return this.hotelOwnerService.getHotelOwner(id);
	}

	@PostMapping("/hotelOwner")
	public HotelOwner addHotel(@RequestBody HotelOwner hotelOwner) {
		System.out.println("inside post");
		return this.hotelOwnerService.addHotelOwner(hotelOwner);
	}

	@PutMapping("/hotelOwner")
	public HotelOwner updateHotel(@RequestBody HotelOwner hotelOwner) {
		return this.hotelOwnerService.updateHotelOwner(hotelOwner);
	}

	@DeleteMapping("/hotelOwner/{hotelOwner_id}")
	public ResponseEntity<HttpStatus> deleteHotelOwner(@PathVariable int id) {
		try {
			this.hotelOwnerService.removeHotelOwner(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
	