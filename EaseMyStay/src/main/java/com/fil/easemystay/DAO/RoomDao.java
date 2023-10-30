package com.fil.easemystay.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;


import com.fil.easemystay.entities.Room;

@Repository
public interface RoomDao  extends JpaRepository<Room, Integer>{

	@Query("SELECT u FROM Room u WHERE u.hotel_id in :hotel_id AND u.status = :status")
	List<Room> findRoom(@Param("hotel_id") int hotel_id,@Param("status") String status);
	
	@Modifying
	@Query("update Room u set u.status = :status where u.room_id = :room_id")
	Room updateRoomStatus(@RequestBody Room room, @Param("room_id") int room_id);
}

