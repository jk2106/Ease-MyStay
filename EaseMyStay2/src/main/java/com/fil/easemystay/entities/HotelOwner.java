package com.fil.easemystay.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HotelOwner {
	private String owner_name;
	 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String owner_id;
	private String id_proof;
	private String owner_contact;

	// Default constructor
	public HotelOwner() {
	}

	// Parameterized constructor
	public HotelOwner(String owner_name, String owner_id, String id_proof, String owner_contact) {
		this.owner_name = owner_name;
		this.owner_id = owner_id;
		this.id_proof = id_proof;
		this.owner_contact = owner_contact;
	}

	// Getters and Setters
	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
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

	@Override
	public String toString() {
		return "HotelOwner [owner_name=" + owner_name + ", owner_id=" + owner_id + ", id_proof=" + id_proof
				+ ", owner_contact=" + owner_contact + "]";
	}

//>>>>>>> branch 'master' of https://github.com/jk2106/Ease-MyStay.git
}
