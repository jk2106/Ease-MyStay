package com.fil.easemystay.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	private int payment_id;
	private String check_in;
	private String check_out;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	User user;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Hotel hotel;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Room room;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	// Getter and Setter methods for each attribute
	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getCheck_in() {
		return check_in;
	}

	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}

	public String getCheck_out() {
		return check_out;
	}

	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}

	// Constructors
	public Booking() {
		// Default constructor
	}

	public Booking(int booking_id, int payment_id, String check_in, String check_out, User user, Hotel hotel,
			Room room) {
		super();
		this.booking_id = booking_id;
		this.payment_id = payment_id;
		this.check_in = check_in;
		this.check_out = check_out;
		this.user = user;
		this.hotel = hotel;
		this.room = room;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", payment_id=" + payment_id + ", check_in=" + check_in
				+ ", check_out=" + check_out + ", user=" + user + ", hotel=" + hotel + ", room=" + room + "]";
	}

}