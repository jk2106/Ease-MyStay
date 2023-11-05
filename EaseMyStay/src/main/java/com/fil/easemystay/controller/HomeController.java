

package com.fil.easemystay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fil.easemystay.entities.User;
import com.fil.easemystay.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("userI")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
//
//	@PostMapping("/signup")
//	public String signUpUser(User user) {
//		this.userService.createUser(user);
//		return "redirect:/login";
//	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	
	@PostMapping("/signup")
	public String signUpUser(User user, Model model) {
	    // Check if the username already exists
	    if (this.userService.doesUsernameExist(user.getUser_email())) {
	        model.addAttribute("errorMessage", "Username already exists. Please choose a different one.");
	        return "signup"; // Return to the signup page with an error message
	    } else {
	        // Username is unique, proceed to create the user
	        this.userService.createUser(user);
	        return "redirect:/login";
	    }
	}

	
	
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("user") @Validated User user, BindingResult bindingResult   , HttpSession session , Model model) {
      String email = user.getUser_email();
      String password = user.getUser_password();
      
      System.out.println(email+"----------------");

      User authenticatedUser = this.userService.loginUser(email, password);
      System.out.println(authenticatedUser);

      if (authenticatedUser != null) {
    	  session.setAttribute("userI", authenticatedUser);
//    	  System.out.println(session.getAttribute("user"));
    	  System.out.println("valid user");
          return  "index";
      } else {
    	  model.addAttribute("errorMessage", "Invalid credentials. Please try again.");
    	  System.out.println("not a valid admin");
          return "login";
      }
	}
	
	
	
	@GetMapping("/easemystay/user/update")
	public String showUpdateForm(Model model , HttpSession session) {
        User user = (User) session.getAttribute("userI");
        model.addAttribute("user", user);
		return "UpdateForm";
	}
	
	@PostMapping("/easemystay/user/update")
	public String updateUser( User user) {
	    this.userService.updateUser(user);
	    return "UpdateForm"; // Redirect to the update form page after update
	}

	
//	@GetMapping("/checkSession")
//	public String checkSession(HttpSession session, Model model) {
//		System.out.println(session.getAttribute("userI"));
//	    Object userAttribute = session.getAttribute("user");
//	    if (userAttribute != null) {
//	        model.addAttribute("userAttribute", userAttribute);
//	    } else {
//	        model.addAttribute("userAttribute", "Session not set or expired");
//	    }
//	    return "checkSession";
//	}
	
	
	
  @GetMapping("/logout")
  public ResponseEntity<String> logout(HttpSession session) {
      session.invalidate();
      return ResponseEntity.status(HttpStatus.OK).body("Logged out successfully");
      }

	
	

}