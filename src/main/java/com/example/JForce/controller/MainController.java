package com.example.JForce.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JForce.model.BookedResponse;
import com.example.JForce.model.IncreaseRoomModel;
import com.example.JForce.model.Logindata;
import com.example.JForce.model.RoomUserEntity;
import com.example.JForce.model.RoomsEntity;
import com.example.JForce.model.SignUpdata;
import com.example.JForce.repositry.RoomsRepo;
import com.example.JForce.repositry.SignUpdataRepository;
import com.example.JForce.service.MainService;
@RestController
public class MainController {

	
	 @Autowired 
     private  SignUpdataRepository  signUpdataRepository;
	 
	 @Autowired 
	 private MainService service1;
	 
	 @Autowired
	 private RoomsRepo roomsRepo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add") // Map ONLY POST Requests
	public  ResponseEntity addNewUser (@RequestBody  SignUpdata s) {
		 try {
			SignUpdata n = new SignUpdata();
		    BeanUtils.copyProperties(s, n);
			signUpdataRepository.save(n);
			return ResponseEntity.ok(HttpStatus.OK);
		 }
		 catch(Exception IllegalArgumentException) {
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		 }
	 }
	
	@CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping("/login" )
			public @ResponseBody Map<String, String> getLoginUser( @RequestBody  Logindata loginData) {
			// This returns a JSON or XML with the users
		 	Logindata l1 = new Logindata();
		 	BeanUtils.copyProperties(loginData, l1);
		 	
		 	  
		 	Map<String, String> map = service1.checkUserDetail(l1);
			return map;
	  }
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/roomsDetails")
	public List<RoomsEntity> foo(@RequestParam String formdate,@RequestParam  String todate) throws ParseException {
		
		
		List<RoomsEntity> roomsList = (List<RoomsEntity>) roomsRepo.findAll();
		if (roomsList == null)
			return null;
		System.out.println(roomsList);
		for (RoomsEntity roomsEntity : roomsList) {
			Boolean  bookedStatus  = false;
			List<RoomUserEntity> roomUserList = roomsEntity.getRoomUserEntity();
			for (RoomUserEntity obj : roomUserList) {
				System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(formdate).compareTo(obj.getFormDate())>0);
				System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(formdate).compareTo(obj.getFormDate())<0);
				if ((new SimpleDateFormat("yyyy-MM-dd").parse(formdate).compareTo(obj.getFormDate())) > 0 &&  new SimpleDateFormat("yyyy-MM-dd").parse(formdate).compareTo(obj.getToDate()) < 0   ||
						(new SimpleDateFormat("yyyy-MM-dd").parse(todate).compareTo(obj.getFormDate())) > 0 &&  new SimpleDateFormat("yyyy-MM-dd").parse(todate).compareTo(obj.getToDate()) < 0){
					bookedStatus = true;
					
				}
			}

			if (bookedStatus == true) {
				roomsEntity.setAvailableStatus("Not Available");
			}
			else {
				roomsEntity.setAvailableStatus("Available");
			}
			
		}
		return roomsList;
		
		//	List<Date> Fromdate = roomsEntity.getFormDate();
		//	List<Date> Todate = roomsEntity.getToDate();
//			if (Fromdate != null && Todate != null && Fromdate.size() >0 && Todate.size() >0) {
//			for(int i =0;i<Fromdate.size();i++) {
//			//	DateTimeFormatter f = DateTimeFormatter.ofPattern( "YYYY-MM-DD" );
//			//	LocalDate ld = LocalDate.parse(todate  , f );
//				
//				if ((new SimpleDateFormat("yyyy-MM-dd").parse(formdate).compareTo(Fromdate.get(i)) > 0 &&  new SimpleDateFormat("yyyy-MM-dd").parse(formdate).compareTo(Todate.get(i)) < 0  ) ||
//						(new SimpleDateFormat("yyyy-MM-dd").parse(todate).compareTo(Fromdate.get(i)) > 0 &&  new SimpleDateFormat("yyyy-MM-dd").parse(todate).compareTo(Todate.get(i)) < 0)) {
//					bookedStatus = true;
//				}
			
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/bookedResponse")
	public ResponseEntity<?> bookedResponse(@RequestBody BookedResponse bookedResponse) {
		System.out.println(bookedResponse);
		for(int i=0;i<bookedResponse.getRoomsNumber().length;i++) {
			RoomsEntity obj = roomsRepo.findByRoomNumber(Integer.parseInt(bookedResponse.getRoomsNumber()[i]));
			List<RoomUserEntity> roomUserList = obj.getRoomUserEntity();
			if (roomUserList == null) {
				roomUserList = new ArrayList<RoomUserEntity>();
			}
			RoomUserEntity roomUserEntity = new RoomUserEntity();
			roomUserEntity.setFormDate(bookedResponse.getFromDate());
			roomUserEntity.setToDate(bookedResponse.getToDate());
			roomUserEntity.setUserMailId(bookedResponse.getUserMailId());
			roomUserEntity.setRoomNumber(Integer.parseInt(bookedResponse.getRoomsNumber()[i]));
			roomUserList.add(roomUserEntity);
			obj.setRoomUserEntity(roomUserList);
			
//			List<Date> formdate = obj.getFormDate();
//			formdate.add(bookedResponse.getFromDate());
//			List<Date> todate = obj.getToDate();
//			todate.add(bookedResponse.getToDate());
			roomsRepo.save(obj);
		}

		return new ResponseEntity<>("It working now!!!!!!!!!!!!",HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping("/getHotelDetails" )
			public  ResponseEntity<?> getHotelDetails() {
		    Integer RoomNumber = roomsRepo.getFloorNumber();
			System.out.println(RoomNumber);
			Map<String,Integer> map = new HashMap<String, Integer>();
			map.put("FloorNumber", RoomNumber);
			return new ResponseEntity<>(map,HttpStatus.OK);
			
	  }
	
	@CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping("/increasedRoom" )
			public  ResponseEntity<?> increasedRoom(@RequestBody IncreaseRoomModel increaseRoomModel) {
			service1.increasedCapacity(increaseRoomModel);
		    Integer RoomNumber = roomsRepo.getFloorNumber();
			System.out.println(RoomNumber);
			Map<String,Integer> map = new HashMap<String, Integer>();
			map.put("FloorNumber", RoomNumber);
			return new ResponseEntity<>(HttpStatus.OK);
			
	  }
}
