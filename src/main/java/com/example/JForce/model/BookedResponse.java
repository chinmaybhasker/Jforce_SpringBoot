package com.example.JForce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.mapping.Array;

public class BookedResponse {
	
	private Date fromDate;
	
	private Date toDate;
	
	private String[] roomsNumber;
	
	private String userMailId;

	public String getUserMailId() {
		return userMailId;
	}

	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}



	

	public String[] getRoomsNumber() {
		return roomsNumber;
	}

	public void setRoomsNumber(String[] roomsNumber) {
		this.roomsNumber = roomsNumber;
	}

	@Override
	public String toString() {
		return "BookedResponse [fromDate=" + fromDate + ", toDate=" + toDate + ", RoomsNumber=" + roomsNumber + "]";
	}
	
	

}
