
 package com.fil.easemystay.entities;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Booking> booking;
	
	@NotBlank(message = "Name cannot be null")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String user_name;
    private String user_dob;
    private String user_contact;
    @NotBlank(message = "Password is required")
    public String user_password;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    public String user_email;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long user_id;


    // Parameterized constructor
    public User(String user_name, String user_dob, String user_contact, String user_password, String user_email, Long user_id) {
        this.user_name = user_name;
        this.user_dob = user_dob;
        this.user_contact = user_contact;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_id = user_id;
    }

    // Getters and Setters
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_dob() {
        return user_dob;
    }

    public void setUser_dob(String user_dob) {
        this.user_dob = user_dob;
    }

    public String getUser_contact() {
        return user_contact;
    }

    public void setUser_contact(String user_contact) {
        this.user_contact = user_contact;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", user_dob=" + user_dob + ", user_contact=" + user_contact
				+ ", user_password=" + user_password + ", user_email=" + user_email + ", user_id=" + user_id + "]";
	}

	

}