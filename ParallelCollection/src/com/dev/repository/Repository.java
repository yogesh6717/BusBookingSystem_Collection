package com.dev.repository;

import java.util.HashMap;

import com.dev.beans.Admin;
import com.dev.beans.Available;
import com.dev.beans.Bus;
import com.dev.beans.User;

public class Repository {

	public static HashMap<Integer, User> usersInfo = new HashMap<>();
	public static HashMap<Integer, Bus> bu = new HashMap<>();
	public static HashMap<Integer, Available> av = new HashMap<>();
	public static HashMap<Integer, Admin> adminInfo =  new HashMap<>();


	

	public Repository() {
	
	User user = new User();
	user.setUserId(1);
	user.setUserName("prasad");
	user.setEmail("prasad@gmail.com");
	user.setContact(951357482);
	user.setUserPassword("root");
	usersInfo.put(1, user);
	
	User user1 = new User();
	user1.setUserId(2);
	user1.setUserName("swapnil");
	user1.setEmail("swapnil@gmail.com");
	user1.setContact(955613282);
	user1.setUserPassword("root");
	usersInfo.put(2, user1);

	Bus bus = new Bus();
	bus.setBusId(101);
	bus.setBusName("VRL Travel");
	bus.setBusType("AC");
	bus.setSource("mumbai");
	bus.setDestination("banglore");
	bus.setTotalSeats(30);
	bus.setPrice(1800);
	bu.put(1, bus);
	
	Bus bus1 = new Bus();
	bus1.setBusId(102);
	bus1.setBusName("SRS Travel");
	bus1.setBusType("NonAC");
	bus1.setSource("mumbai");
	bus1.setDestination("hyderabad");
	bus1.setTotalSeats(25);
	bus1.setPrice(1700);
	bu.put(2, bus1);
	
	
	Available available = new Available();
	available.setBusId(101);
	available.setAvailableId(201);
	available.setAvailableDate("2019-08-20");
	available.setAvailableSeats(30);
	av.put(1, available);
	
	Admin admin = new Admin();
	
	admin.setAdminId(301);
	admin.setAdminPassword("root");
	adminInfo.put(1, admin);

	} 
}
