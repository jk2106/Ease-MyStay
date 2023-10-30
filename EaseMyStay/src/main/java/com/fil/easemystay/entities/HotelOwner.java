package com.fil.easemystay.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

@Entity
public class HotelOwner {
	private String owner_name;
	@Id
	private int owner_id;
	private String email;
	private String password;
	private String id_proof;
	private String owner_contact;
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId_proof() {
		return id_proof;
	}
	public void setId_proof(String id_proof) {
		this.id_proof = id_proof;
	}
	public String getOwner_contact() {
		return owner_contact;
	}
	public void setOwner_contact(String owner_contact) {
		this.owner_contact = owner_contact;
	}
	public HotelOwner(String owner_name, int owner_id, String email, String password, String id_proof,
			String owner_contact) {
		super();
		this.owner_name = owner_name;
		this.owner_id = owner_id;
		this.email = email;
		this.password = password;
		this.id_proof = id_proof;
		this.owner_contact = owner_contact;
	}
	public HotelOwner() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HotelOwner [owner_name=" + owner_name + ", owner_id=" + owner_id + ", email=" + email + ", password="
				+ password + ", id_proof=" + id_proof + ", owner_contact=" + owner_contact + "]";
	}
	
}