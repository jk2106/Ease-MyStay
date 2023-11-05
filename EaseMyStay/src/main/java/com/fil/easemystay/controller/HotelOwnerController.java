

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fil.easemystay.entities.Admin;
import com.fil.easemystay.entities.Hotel;
import com.fil.easemystay.entities.HotelOwner;
import com.fil.easemystay.entities.Room;
import com.fil.easemystay.service.HotelOwnerService;

import jakarta.servlet.http.HttpSession;

//@RequestMapping("api/v1/")
@Controller
public class HotelOwnerController {

	@Autowired
	private HotelOwnerService hotelOwnerService;

	@GetMapping("/hotelOwners")
	public String getHotelOwners(Model model) {
		System.out.println("inside get");
		List<HotelOwner> owners = hotelOwnerService.getHotelOwners();
		model.addAttribute("owners",owners );
		System.out.println(owners);
		return "ownerList";
	}

	// add new owner:
		@GetMapping("/hotelOwners/signup")
		public String addOwnerForm(Model model) {
			model.addAttribute("owner", new HotelOwner());
			return "ownerSignUp";
		}

		@PostMapping("/hotelOwners/signup")
		public String addHotelOwner(@ModelAttribute("hotelOwner") HotelOwner newHotelOwner) {
			System.out.println("inside post");
			this.hotelOwnerService.addHotelOwner(newHotelOwner);
			// model.addAttribute("hotel", newHotel);
			return "redirect:/hotelOwners/login";
		}
		
		@GetMapping("/hotelOwners/delete/{id}")
		public String deleteHotelOwner(@PathVariable int id) {
			try {
				this.hotelOwnerService.removeHotelOwner(id);
				return "redirect:/hotelOwners";
			} catch (Exception e) {
				return "redirect:/hotelOwners";
			}
		}
		
		@GetMapping("hotelOwners/login")
		public String showLoginForm(Model model) {
			model.addAttribute("owner", new HotelOwner());
			return "ownerlogin";
		}
		@PostMapping("hotelOwners/login")
		public String loginHotelOwner(HotelOwner  owner, Model model) throws Exception {
	      String email = owner.getEmail();
	      String password = owner.getPassword();
	   
//	      System.out.println("owner_id"+ owner.getOwner_id());
	      System.out.println(email+"-----------------------");

	      HotelOwner authenticatedOwner = this.hotelOwnerService.loginOwner(email, password);

	      if (authenticatedOwner != null) {
	    	  System.out.println("valid owner");
	    	  return "redirect:/hotelByEmail/"+email;
	      } else {
	    	  model.addAttribute("errorMessage", "Invalid credentials. Please try again.");
	    	  System.out.println("not a valid owner");
	          return "ownerlogin";
	      }
		}
		
		
		  @GetMapping("hotelOwners/logout")
		  public ResponseEntity<String> logout(HttpSession session) {
		      session.invalidate();
		      String alertScript = "<script>alert('Logged out successfully');</script>";
		      
		      // You can redirect to a URL that triggers the JavaScript alert
		      // Or, return a script to the client to display the alert
		      return ResponseEntity.status(HttpStatus.OK).body(alertScript);
		      
		      }

			
}