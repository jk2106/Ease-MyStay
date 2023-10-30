package com.fil.easemystay.service;

import java.util.List;

import com.fil.easemystay.entities.HotelOwner;

public interface HotelOwnerService {
	public List<HotelOwner> getHotelOwners();
	public HotelOwner getHotelOwner(int owner_id);
	public HotelOwner addHotelOwner(HotelOwner hotelOwner);
	public HotelOwner updateHotelOwner(HotelOwner hotelOwner);
	public void removeHotelOwner(int owner_id);
}