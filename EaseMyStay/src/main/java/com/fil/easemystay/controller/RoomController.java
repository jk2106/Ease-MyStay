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

import com.fil.easemystay.entities.Room;
import com.fil.easemystay.service.RoomService;

@RestController
@RequestMapping("/api/v1/hotel")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public List<Room> getRooms() {
		return this.roomService.getRooms();
	}

	@GetMapping("/room/{room_id}")
	public Room getRoom(@PathVariable int room_id) {
		return this.roomService.getRoom(room_id);
	}
	
	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room room) {
		return this.roomService.addRoom(room);
	}

	@PutMapping("/rooms")
	public Room updateRoom(@RequestBody Room room) {
		return this.roomService.updateRoom(room);
	}
	
	
	@DeleteMapping("/room/{room_id}")
	public ResponseEntity<HttpStatus> deleteRoom(@PathVariable String id) {
		try {
			
			this.roomService.deleteRoom(Integer.parseInt(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
