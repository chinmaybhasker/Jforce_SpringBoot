package com.example.JForce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JForce.model.IncreaseRoomModel;
import com.example.JForce.model.Logindata;
import com.example.JForce.model.SignUpdata;
import com.example.JForce.repositry.RoomsRepo;
import com.example.JForce.repositry.SignUpdataRepository;


@Service
public class MainService {
	
	@Autowired
	private SignUpdataRepository signUpdataRepository;
	
	 @Autowired
	 private RoomsRepo roomsRepo;
	
	public  Map<String, String> checkUserDetail(Logindata loginData) {
		Map<String, String> map=new HashMap();  
		Iterable<SignUpdata> list = new ArrayList<>();
		list = signUpdataRepository.findAll();
		for (SignUpdata signUpdata : list) {
			if (loginData.getEmailaddress().equals(signUpdata.getUserName())) {
				if (loginData.getPassword().equals(signUpdata.getPassword())) {
					
					map.put("response", "Valid User");
					map.put("Name", signUpdata.getFirstName());
					if (signUpdata.getAdminFlag() != null && signUpdata.getAdminFlag() == true) {
						map.put("adminAccess", "true");
					}
					else {
						map.put("adminAccess", "false");
					}
					return map;
				}
			}
		}
		 map.put("response", "Invalid User");
		return map;
	}
	
	public String increasedCapacity(IncreaseRoomModel increaseRoomModel){
		System.out.println(increaseRoomModel);
		Integer FloorNumber = increaseRoomModel.getFloorNumber();
		Integer InitialFloorNumber = roomsRepo.getFloorNumber();
		Integer id = roomsRepo.getId();
		id++;
		for(int i= InitialFloorNumber;i<FloorNumber;i++) {
			for(int j = 1;j <= increaseRoomModel.getRoomCapacity();j++,id++) {
				Integer QueryFloorNumber = i+1;
				String queryRoomNumber = "";
				if (j<10) {
					queryRoomNumber = QueryFloorNumber+"0"+j;
				}
				else {
					queryRoomNumber = QueryFloorNumber+""+j;
				}
			roomsRepo.increaseCapacity(id,QueryFloorNumber,Integer.parseInt(queryRoomNumber));
			}
		}
		return null;
		
	}
	

}

