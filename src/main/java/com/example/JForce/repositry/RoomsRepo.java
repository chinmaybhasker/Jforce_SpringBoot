package com.example.JForce.repositry;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.JForce.model.RoomsEntity;

public interface RoomsRepo extends CrudRepository<RoomsEntity, Integer> {

	
	public RoomsEntity findByRoomNumber(int roomNumber);
	
	@Query(value = "Select max(n.floorNumber)  from RoomsEntity n  ",nativeQuery = false)
	public  Integer getFloorNumber();
	
	@Query(value = "Select max(n.id)  from RoomsEntity n  ",nativeQuery = false)
	public  Integer getId();

	
	
	@Modifying
	@Transactional(rollbackOn=Exception.class)
	@Query(value = "insert into Rooms_Entity  (id,floor_Number,room_Number)  values (:id,:floorNumber,:RoomNumber)",nativeQuery = true)
	public  Integer increaseCapacity(int id,int floorNumber,int RoomNumber);
}

//:floorNumber,:RoomNumber