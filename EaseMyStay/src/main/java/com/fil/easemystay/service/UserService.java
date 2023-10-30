package com.fil.easemystay.service;


import java.util.List;

import com.fil.easemystay.entities.Booking;
import com.fil.easemystay.entities.Hotel;
import com.fil.easemystay.entities.Room;


public interface UserService {
	public List<Hotel> findHotels(String city);
  
	public List<Room>  findRooms(int hotel_id,String status);
  
	public Booking reserveRoom(Booking booking);
  
	public List<Booking> findBookings(int booking_id);
  
	public Room updateRoomStatus(Room room,int room_id, String Status);
	
	
	public User createUser(User user);
	
	public User loginUser(String username, String password);

	public User updateUser(User user);

	public boolean deleteUser(User user);
}


