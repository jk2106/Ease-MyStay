package com.fil.easemystay.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_id;
	private int price;
	private String status;
	private String room_desc;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "hotel_id")
	Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
	private List<Booking> booking;

	// Getter and Setter methods for each attribute
	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoom_desc() {
		return room_desc;
	}

	public void setRoom_desc(String room_desc) {
		this.room_desc = room_desc;
	}

	// Default constructor
	public Room() {
	}

	public Room(int room_id, int price, String status, String room_desc, Hotel hotel, List<Booking> booking) {
		super();
		this.room_id = room_id;
		this.hotel = hotel;
		this.price = price;
		this.status = status;
		this.room_desc = room_desc;
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", price=" + price + ", status=" + status + ", room_desc=" + room_desc
				+ ", hotel=" + hotel + ", booking=" + booking + "]";
	}

}
=======
	  private int room_id;
	    private int hotel_id;
	    private int price;
	    private String status;
	    private String room_desc;

	    // Default constructor
	    public Room() {
	    }

	    // Parameterized constructor
	    public Room(int room_id, int hotel_id, int price, String status, String room_desc) {
	        this.room_id = room_id;
	        this.hotel_id = hotel_id;
	        this.price = price;
	        this.status = status;
	        this.room_desc = room_desc;
	    }

	 // Getter and Setter methods for each attribute
	    public int getRoom_id() {
	        return room_id;
	    }

	    public void setRoom_id(int room_id) {
	        this.room_id = room_id;
	    }

	    public int getHotel_id() {
	        return hotel_id;
	    }

	    public void setHotel_id(int hotel_id) {
	        this.hotel_id = hotel_id;
	    }

	    public int getPrice() {
	        return price;
	    }
	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getRoom_desc() {
	        return room_desc;
	    }

	    public void setRoom_desc(String room_desc) {
	        this.room_desc = room_desc;
	    }

		@Override
		public String toString() {
			return "Room [room_id=" + room_id + ", hotel_id=" + hotel_id + ", price=" + price + ", status=" + status
					+ ", room_desc=" + room_desc + "]";
		}


}
