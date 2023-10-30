package com.fil.easemystay.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fil.easemystay.entities.Room;

@Repository
public interface RoomDao  extends JpaRepository<Room, Integer>{

}
