package com.fil.easemystay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.easemystay.DAO.RoomDao;
import com.fil.easemystay.entities.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDao;
	
	@Override
	public List<Room> getRooms() {
		// TODO Auto-generated method stub
		return roomDao.findAll();
	}

	@Override
	public Room getRoom(int room_id) {
		// TODO Auto-generated method stub
		return roomDao.findById(room_id).get();
	}

	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		roomDao.save(room);
		return room;
	}

	@Override
	public Room updateRoom(Room room) {
		// TODO Auto-generated method stub
		roomDao.save(room);
		return room;
	}

	@Override
	public void deleteRoom(int room_id) throws Exception {
		// TODO Auto-generated method stub
		roomDao.deleteById(room_id);
		
	}

}
