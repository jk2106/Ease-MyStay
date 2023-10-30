package com.fil.easemystay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.easemystay.DAO.BookingDao;
import com.fil.easemystay.DAO.HotelDao;
import com.fil.easemystay.DAO.RoomDao;
import com.fil.easemystay.DAO.UserDao;
import com.fil.easemystay.entities.Booking;
import com.fil.easemystay.entities.Hotel;
import com.fil.easemystay.entities.Room;

import org.springframework.data.jpa.repository.Query;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private HotelDao hoteldao;
	@Autowired
	private RoomDao roomdao;
	@Autowired
	private BookingDao bookingdao;

	
	@Override
	public List<Hotel> findHotels(String city) {
		return hoteldao.findByname(city);		
	}
	
	@Override
	public List<Room> findRooms(int hotel_id,String status) {
		
		return roomdao.findRoom(hotel_id,status);
	}
	
	@Override
	public Booking reserveRoom(Booking booking){
		bookingdao.save(booking);
		return booking;
	}
	
	@Override
	public List<Booking> findBookings(int user_id) {
		return bookingdao.getAllBookings(user_id);		
	}
	
	@Override
	public Room updateRoomStatus(Room room,int room_id,String status) {
		roomdao.save(room);
		return room;
		}
}
