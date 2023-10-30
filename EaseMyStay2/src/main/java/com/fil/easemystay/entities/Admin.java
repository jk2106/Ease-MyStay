package com.fil.easemystay.entities;

import jakarta.persistence.Entity;
//<<<<<<< HEAD
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	private int id;
	private String user_name;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(int id, String user_name, String password) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", user_name=" + user_name + ", password=" + password + "]";
	}
}