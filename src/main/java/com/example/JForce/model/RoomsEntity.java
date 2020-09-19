package com.example.JForce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class RoomsEntity {
	
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id", unique = true, nullable = false)
	  private int id;
	  
	  @Column
	  private int roomNumber;
	  
	  

	  @Column
	  private Integer floorNumber;
	  
	  @Column
	  private String availableStatus;
	  
	 // @OneToMany(mappedBy = "RoomUserEntity",cascade = CascadeType.ALL,orphanRemoval = true,fetch=FetchType.LAZY)
	  @OneToMany(cascade=CascadeType.ALL)
	  @JoinColumn(name = "RoomUserId")
	  private List<RoomUserEntity> roomUserEntity;
	  
	  public List<RoomUserEntity> getRoomUserEntity() {
		return roomUserEntity;
	}

	public void setRoomUserEntity(List<RoomUserEntity> roomUserEntity) {
		this.roomUserEntity = roomUserEntity;
	}

	public String getAvailableStatus() {
		return availableStatus;
	}

	public void setAvailableStatus(String availableStatus) {
		this.availableStatus = availableStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}
}
