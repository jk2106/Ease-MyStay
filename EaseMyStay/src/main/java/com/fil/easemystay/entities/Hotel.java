package com.fil.easemystay.entities;

public class Hotel {
	private int hotel_id;
    private String hotel_name;
    private String city;
    private String state;
    private String hotel_pincode;
    private String hotel_contact;
    private int no_of_rooms;

    // Default constructor
    public Hotel() {
    }

    // Parameterized constructor
    public Hotel(int hotel_id, String hotel_name, String city, String state, String hotel_pincode, String hotel_contact, int no_of_rooms) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.city = city;
        this.state = state;
        this.hotel_pincode = hotel_pincode;
        this.hotel_contact = hotel_contact;
        this.no_of_rooms = no_of_rooms;
    }
    
    // Getters and Setters
    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHotel_pincode() {
        return hotel_pincode;
    }

    public void setHotel_pincode(String hotel_pincode) {
        this.hotel_pincode = hotel_pincode;
    }

    public String getHotel_contact() {
        return hotel_contact;
    }

    public void setHotel_contact(String hotel_contact) {
        this.hotel_contact = hotel_contact;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }
    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", city=" + city + ", state=" + state
				+ ", hotel_pincode=" + hotel_pincode + ", hotel_contact=" + hotel_contact + ", no_of_rooms="
				+ no_of_rooms + "]";
	}

    // You can also override the toString method for better representation
   

}
