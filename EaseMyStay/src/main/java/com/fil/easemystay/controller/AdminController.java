package com.fil.easemystay.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fil.easemystay.entities.Admin;
import com.fil.easemystay.entities.User;
import com.fil.easemystay.service.AdminService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/easemystay/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("admin", new Admin());
		return "Adminlogin";
	}

	@PostMapping("/login")
	public String loginAdmin(Admin  admin , Model model) {
      String email = admin.getEmail();
      String password = admin.getPassword();
      
      System.out.println(email+"-----------------------");

      Admin authenticatedAdmin = this.adminService.loginAdmin(email, password);

      if (authenticatedAdmin != null) {
    	  System.out.println("valid admin");
          return  "redirect:/hotelOwners";
      } else {
    	  model.addAttribute("errorMessage", "Invalid credentials. Please try again.");
    	  System.out.println("not a valid admin");
          return "Adminlogin";
      }
	}
	


}
