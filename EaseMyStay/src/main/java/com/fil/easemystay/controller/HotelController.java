package com.fil.easemystay.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fil.easemystay.entities.Hotel;
import com.fil.easemystay.entities.Room;
import com.fil.easemystay.service.HotelService;
import com.fil.easemystay.service.RoomService;

@RestController
@RequestMapping("api/v1/")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private RoomService roomService;

	@GetMapping("/home")
	public String home() {
		return "Hello World";
	}

	@GetMapping("/hotels")
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

	@DeleteMapping("/hotel/{id}")
	public ResponseEntity<HttpStatus> deleteHotel(@PathVariable int id) {
		try {
			
			this.hotelService.removeHotel(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/hotel/rooms")
	public List<Room> getRooms() {
		return this.roomService.getRooms();
	}

	@GetMapping("/hotel/room/{room_id}")
	public Room getRoom(@PathVariable int room_id) {
		return this.roomService.getRoom(room_id);
	}
	
	@PostMapping("/hotel/room")
	public Room addRoom(@RequestBody Room room) {
		return this.roomService.addRoom(room);
	}

	@PutMapping("/hotel/room")
	public Room updateRoom(@RequestBody Room room) {
		return this.roomService.updateRoom(room);
	}
	
	
	@DeleteMapping("/hotel/room/{room_id}")
	public ResponseEntity<HttpStatus> deleteRoom(@PathVariable String id) {
		try {
			
			this.roomService.deleteRoom(Integer.parseInt(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}