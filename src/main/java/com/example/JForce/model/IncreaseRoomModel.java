package com.example.JForce.model;

public class IncreaseRoomModel {
	
	private Integer floorNumber;
	
	private Integer roomCapacity;

	
	public Integer getFloorNumber() {
		return floorNumber;
	}


	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}


	public Integer getRoomCapacity() {
		return roomCapacity;
	}


	public void setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
	}


	@Override
	public String toString() {
		return "IncreaseRoomModel [floorNumber=" + floorNumber + ", roomCapacity=" + roomCapacity + "]";
	}


	
	

}
