package com.fil.easemystay.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	private String user_name;
    private String user_dob;
    private String user_contact;
    private String user_password;
    private String user_email;
    @Id
    private String user_id;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String user_name, String user_dob, String user_contact, String user_password, String user_email, String user_id) {
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", user_dob=" + user_dob + ", user_contact=" + user_contact
				+ ", user_password=" + user_password + ", user_email=" + user_email + ", user_id=" + user_id + "]";
	}


}
