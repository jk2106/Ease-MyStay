package com.fil.easemystay.service;

import java.util.List;

import com.fil.easemystay.entities.Room;

public interface RoomService {

	public List<Room> getRooms();
	public Room getRoom(int room_id);
	public Room addRoom(Room room);
	public Room updateRoom(Room room);
	public void deleteRoom(int room_id) throws Exception;
	

}
