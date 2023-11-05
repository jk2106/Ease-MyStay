
package com.fil.easemystay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fil.easemystay.entities.Hotel;
import com.fil.easemystay.entities.HotelOwner;
import com.fil.easemystay.entities.Room;
import com.fil.easemystay.service.HotelOwnerService;
import com.fil.easemystay.service.HotelService;
import com.fil.easemystay.service.RoomService;

@Controller
//@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private RoomService roomService;

	@Autowired
	private HotelOwnerService hotelOwnerService;

	// Get all hotels
	@GetMapping("/hotels")
	public String getHotels(Model model) {
		System.out.println("inside get");
		List<Hotel> hotels = hotelService.getHotels();
		model.addAttribute("hotels", hotels);
		return "hotelList";
	}

	// get hotels based on owner id
	@GetMapping("/hotels/{owner_id}")
	public String getHotels(Model model, @PathVariable int owner_id) {
		System.out.println("inside get");
		HotelOwner hotelOwner = hotelOwnerService.getHotelOwner(owner_id);
		if (hotelOwner != null) {
			// Get the list of hotels associated with the owner
			List<Hotel> hotels = hotelOwner.getHotel();
			model.addAttribute("hotelOwner", hotelOwner);
			model.addAttribute("hotels", hotels);
			return "hotelList";
		} else {
			// if the owner is not found
			return "redirect:/hotelOwners";
		}
	}

	// get hotels based on email of owner
	@GetMapping("/hotelByEmail/{owner_email}")
	public String getHotelByEmail(Model model, @PathVariable String owner_email) {
		System.out.println("inside get");
		HotelOwner hotelOwner = hotelOwnerService.getHotelOwnerByEmail(owner_email);
		if (hotelOwner != null) {
			// Get the list of rooms associated with the hotel
			List<Hotel> hotels = hotelOwner.getHotel();
			model.addAttribute("hotelOwner", hotelOwner);
			model.addAttribute("hotels", hotels);
			return "hotelList";
		} else {
			// Handle the case where the hotel is not found
			return "redirect:/hotelOwners";
		}
	}

	// Get hotel by Hotel ID
	@GetMapping("/hotelById/{id}")
	public String getHotelById(@PathVariable int id, Model model) {
		Hotel hotel = hotelService.getHotel(id);

		if (hotel != null) {
			model.addAttribute("hotel", hotel);
			return "hotel";
		} else {
			// hotel is not found
			return "redirect:/hotels";
		}
	}

	// Add new hotel:
	@GetMapping("/hotels/create")
	public String addHotelForm(Model model) {
		model.addAttribute("hotel", new Hotel());
		return "hotelForm";
	}

	// Add a hotel to a hotelOwner (Cascading operation)
	@PostMapping("/hotels/create")
	public String addHotelToHotelOwner(@RequestParam int hotel_owner_owner_id, @ModelAttribute("hotel") Hotel hotel,
			Model model) {

		HotelOwner owner = hotelOwnerService.getHotelOwner(hotel_owner_owner_id);

		if (owner != null) {
			System.out.println("owner found");
			// Associate the hotel with the hotelowner
			hotel.setHotelOwner(owner);
			// Save the hotel, and the cascading operation will also update the hotelOwner
			owner.getHotel().add(hotel);
			this.hotelOwnerService.updateHotelOwner(owner);

			// Add necessary attributes to the model
			model.addAttribute("owners", hotelOwnerService.getHotelOwners());
			model.addAttribute("hotel", new Hotel()); // if needed for adding more rooms
			return "redirect:/hotels/" + hotel_owner_owner_id;
		} else {
			// Handle the case where the owner is not found
			return "redirect:/owners";
		}
	}

	// Editing the hotel details
	@GetMapping("/hotels/edit/{id}")
	public String editHotelForm(@PathVariable int id, Model model) {
		Hotel hotel = hotelService.getHotel(id);
		if (hotel != null) {
			model.addAttribute("hotel", hotel);
			return "editHotel";
		} else {
			// Handle the case where the hotel is not found
			return "redirect:/hotels"; // Redirect to the hotel list or an error page
		}
	}

	@PostMapping("/hotels/edit/{id}")
	public String updateHotel(@ModelAttribute("hotel") Hotel editedHotel, @PathVariable int id, Model model) {
		// editing the hotel table in database
		Hotel hotel = hotelService.getHotel(id);
		int owner_id = hotel.getHotelOwner().getOwner_id();
		if (hotel != null) {
			hotel.setHotel_name(editedHotel.getHotel_name());
			hotel.setHotel_contact(editedHotel.getHotel_name());
			hotel.setNo_of_rooms(editedHotel.getNo_of_rooms());
			hotel.setCity(editedHotel.getCity());
			hotel.setState(editedHotel.getState());
			hotel.setHotel_pincode(editedHotel.getHotel_pincode());
		}
		hotelService.addHotel(hotel);
		return "redirect:/hotels/" + owner_id;
	}

	// ROOM CONTROLLERS:----------------------------------------------

//get all rooms based on hotel id	
	@GetMapping("/hotels/rooms/{hotel_id}")
	public String getRooms(Model model, @PathVariable int hotel_id) {
		System.out.println("inside get");
		Hotel hotel = hotelService.getHotel(hotel_id);
		if (hotel != null) {
			// Get the list of rooms associated with the hotel
			List<Room> rooms = hotel.getRooms();
			model.addAttribute("hotel", hotel);
			model.addAttribute("rooms", rooms);
			return "roomList";
		} else {
			// Handle the case where the hotel is not found
			return "redirect:/hotels";
		}
	}

	// add new room to hotel:(cascading)
	@GetMapping("/hotels/rooms/create")
	public String addRoomForm(Model model) {
		model.addAttribute("room", new Room());
		return "roomForm";
	}

	@PostMapping("/hotels/rooms/create")
	public String addRoomToHotel(@RequestParam int hotel_hotel_id, @ModelAttribute("room") Room room, Model model) {

		Hotel hotel = hotelService.getHotel(hotel_hotel_id);

		if (hotel != null) {
			System.out.println("hotel found");
			// Associate the room with the hotel
			room.setHotel(hotel);
			// Save the room, and the cascading operation will also update the hotel
			hotel.getRooms().add(room);
			this.hotelService.updateHotel(hotel);

			// updating room in room table
		//	this.roomService.addRoom(room);

			// Add necessary attributes to the model
			model.addAttribute("hotels", hotelService.getHotels());
			model.addAttribute("room", new Room()); // if needed for adding more rooms
			model.addAttribute("hotel_id", hotel_hotel_id);
			return "redirect:/hotels/rooms/" + hotel_hotel_id;
		} else {
			// Handle the case where the room is not found
			return "redirect:/hotels";
		}
	}
}