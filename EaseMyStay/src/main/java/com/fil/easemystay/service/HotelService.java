package com.fil.easemystay.service;

import java.util.List;

import com.fil.easemystay.entities.Hotel;

public interface HotelService {
	public List<Hotel> getHotels();
	public Hotel getHotel(int hotel_id);
	public Hotel addHotel(Hotel hotel);
	public Hotel updateHotel(Hotel hotel);
	public void removeHotel(int hotel_id);
}