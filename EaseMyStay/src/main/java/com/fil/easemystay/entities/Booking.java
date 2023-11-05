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

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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
	 private int booking_id;
	    private int room_id;
	    private int user_id;
	    private int payment_id;
	    private String check_in;
	    private String check_out;

	    // Constructors
	    public Booking() {
	        // Default constructor
	    }

	    public Booking(int booking_id, int room_id, int user_id, int payment_id, String check_in, String check_out) {
	        this.booking_id = booking_id;
	        this.room_id = room_id;
	        this.user_id = user_id;
	        this.payment_id = payment_id;
	        this.check_in = check_in;
	        this.check_out = check_out;
	    }
	 // Getter and Setter methods for each attribute
	    public int getBooking_id() {
	        return booking_id;
	    }

	    public void setBooking_id(int booking_id) {
	        this.booking_id = booking_id;
	    }

	    public int getRoom_id() {
	        return room_id;
	    }

	    public void setRoom_id(int room_id) {
	        this.room_id = room_id;
	    }

	    public int getUser_id() {
	        return user_id;
	    }
	    public void setUser_id(int user_id) {
	        this.user_id = user_id;
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

		@Override
		public String toString() {
			return "Booking [booking_id=" + booking_id + ", room_id=" + room_id + ", user_id=" + user_id
					+ ", payment_id=" + payment_id + ", check_in=" + check_in + ", check_out=" + check_out + "]";
		}

}
