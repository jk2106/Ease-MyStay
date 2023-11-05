package com.fil.easemystay.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fil.easemystay.entities.Booking;
import com.fil.easemystay.entities.Hotel;
import com.fil.easemystay.entities.Room;
import com.fil.easemystay.entities.User;
import com.fil.easemystay.service.HotelService;
import com.fil.easemystay.service.PaymentServiceImpl;
import com.fil.easemystay.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("helloo123");
		 return "index";
	}
	@RequestMapping("/search")
	public String search() {
		System.out.println("helloo123");
		 return "search";
	}
	
	
	 @GetMapping("/search_hotels")
	    public String searchHotelsByCity(@RequestParam("city") String city, Model model) {
	        List<Hotel> hotels = userService.findHotels(city);
	       
	        
	        if (hotels != null) {
	        	 model.addAttribute("hotels", hotels);
	            return "showSearchedHotel";
	        }
	        return "redirect:/home";

	    }
	 @GetMapping("user/rooms/{hotel_id}")
	    public String availableRooms(@PathVariable int hotel_id, Model model) {
		 String status="Available";
	        List<Room> rooms = userService.findRooms(hotel_id,status);
	       
	       System.out.println(hotel_id);
	        if (rooms != null) {
	        	 model.addAttribute("rooms", rooms);
	        	 model.addAttribute("hotel_hotel_id", hotel_id);
	        	 //model.addAttribute("hotel_id", hotel_id);
	            return "showAvailableRooms";
	        }
	        return "redirect:/home";

	    }
	 
	 @GetMapping("/reserve/{hotel_id}/{room_id}")
		public String go2(Model model, @PathVariable int room_id, @PathVariable int hotel_id,HttpSession session) {
		 System.out.println(session.getAttribute("userI"));
		 Object userObject = session.getAttribute("userI");
		 System.out.println(userObject);
		 long user_id=0;
		// Check if the 'user' attribute exists and is of the expected type
		if (userObject != null && userObject instanceof User) {
		    User user = (User) userObject;

		     user_id = user.getUser_id(); 
		} else {
		    System.out.println("User attribute not found or is not of the expected type.");
		}
		// System.out.println(user_id);
		 model.addAttribute("hotel_id", hotel_id);
		 model.addAttribute("room_id", room_id);
		 model.addAttribute("user_id", user_id);
		 System.out.println(user_id);
		  model.addAttribute("booking", new Booking());
			 return "reserveRoom";
		}
	 
	 
//	 @RequestMapping("/reserve/{hotel_id}/{room_id}")
//		public String go2() {
//			 return "reserveRoom";
//		}
	
//	 @PostMapping("/reserve/{room_id}")
//		public String bookRoom(@ModelAttribute Booking booking,@PathVariable int room_id) {
//			booking = userService.reserveRoom(booking,room_id);
//			return "bookings";
//		}
	 
	 @PostMapping("/book/{hotel_id}/{room_id}/{user_id}")
	    public String reserveRoom(@ModelAttribute Booking booking, @PathVariable int room_id,@PathVariable int user_id,@PathVariable int hotel_id, Model model) {
		 Room room = userService.findRoomById(room_id);
		    User user = userService.findUserById(user_id);
		 Hotel hotel = userService.findHotelById(hotel_id);
		 
		    booking.setRoom(room);
		    booking.setUser(user);
		    booking.setHotel(hotel);
		    

		 	booking = userService.reserveRoom(booking, room_id,user_id);
	        model.addAttribute("booking", booking);
	        
	        List<Booking> bookings = userService.findBookings(user_id);
	        model.addAttribute("bookings", bookings);

	        return "bookings"; // Assuming "reservationConfirmation.html" is the confirmation page
	    }
	 
	 @GetMapping("/show_bookings")
		public String getUserBookings(HttpSession session, Model model) {
		 Object userObject = session.getAttribute("userI");
		 System.out.println(userObject);
		 long user_id=0;
		// Check if the 'user' attribute exists and is of the expected type
		if (userObject != null && userObject instanceof User) {
		    User user = (User) userObject;

		     user_id = user.getUser_id();
		} else {
		    System.out.println("User attribute not found or is not of the expected type.");
		}
		List<Booking> bookings = userService.findBookings((int)user_id);
        model.addAttribute("bookings", bookings);

        return "bookings";
}
//	 @GetMapping("/generateQR/{payment_id}/{amount}/{book_id}/{date}")
//	 public String generateQR(
//		        @PathVariable int payment_id,
//		        @PathVariable int amount,
//		        @PathVariable int book_id,
//		        @PathVariable String date,
//		        Model model
//		    ) {
//		        String qrText = "Payment ID: " + payment_id + ", Amount: " + amount + ", Book ID: " + book_id + ", Date: " + date;
//
//		        try {
//		            BitMatrix bitMatrix = new QRCodeWriter().encode(qrText, BarcodeFormat.QR_CODE, 200, 200);
//		            String qrImage = "data:image/png;base64," + QRCodeUtil.convertBitMatrixToBase64(bitMatrix);
//		            System.out.println(qrImage);
//		            model.addAttribute("qrImage", qrImage);
//		        } catch (WriterException | IOException e) {
//		            // Handle exception
//		            e.printStackTrace();
//		        }
//
//		        return "qrCodePage";
//		    }
	
}
