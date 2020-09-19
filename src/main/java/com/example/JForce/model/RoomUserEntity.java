package com.example.JForce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class RoomUserEntity {
	
	  @Id
	  @GeneratedValue
	  @Column
	  private long RoomUserId;
	
	  @Column
	  private Date formDate;
	  
	  @Column
	  private Date toDate;
	  
	  @Column
	  private String UserMailId;
	  
	  @Column
	  private int roomNumber;
	  
	  public int getRoomNumber() {
		return roomNumber;
	}

		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}
	
		
	  
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "id", referencedColumnName = "id")
	  private RoomsEntity roomsEntity;
	
	  public long getRoomUserId() {
		return RoomUserId;
	}

	public void setRoomUserId(long roomUserId) {
		RoomUserId = roomUserId;
	}



	public Date getFormDate() {
		return formDate;
	}

	public void setFormDate(Date formDate) {
		this.formDate = formDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getUserMailId() {
		return UserMailId;
	}

	public void setUserMailId(String userMailId) {
		UserMailId = userMailId;
	}

	public RoomsEntity getRoomsEntity() {
		return roomsEntity;
	}

	public void setRoomsEntity(RoomsEntity roomsEntity) {
		this.roomsEntity = roomsEntity;
	}

	 
	  
	  
	  

}
