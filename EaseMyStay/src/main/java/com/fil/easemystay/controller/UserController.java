package com.fil.easemystay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fil.easemystay.entities.Booking;
import com.fil.easemystay.entities.Hotel;
import com.fil.easemystay.entities.Room;
import com.fil.easemystay.entities.User;
import com.fil.easemystay.service.UserService;
import com.fil.easemystay.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("helloo123");
		 return "index";
	}
	
	@GetMapping("/hotel/{city}")
	public List<Hotel> findHotels(@PathVariable String city) {
		return this.userService.findHotels(city);
	}
	
	@GetMapping("/rooms/{hotel_id}")
	public List<Room> findRooms(@PathVariable int hotel_id) {
		String status="Available";
		return this.userService.findRooms(hotel_id,status);
	}
	@PostMapping("/reserve/{room_id}/{user_id}")
	public Booking bookRoom(@RequestBody Booking booking) {
		return this.userService.reserveRoom(booking);
	}
	
	@GetMapping("/bookings/{user_id}")
	public List<Booking> getUserBookings(@PathVariable int user_id) {
		return this.userService.findBookings(user_id);
	}
	@PutMapping("/update/{room_id}")
	public Room updateRoomstatus(@RequestBody Room room,
			@PathVariable int room_id) {
		String status="not available";
		return this.userService.updateRoomStatus(room,room_id,status);
	}
}
