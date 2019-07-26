package com.dev.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.dev.beans.Admin;
import com.dev.beans.Available;
import com.dev.beans.Bus;
import com.dev.beans.Suggestion;
import com.dev.beans.Ticket;
import com.dev.beans.User;
import com.dev.repository.Repository;

public class BusBookingCollectionImpl implements BusBookingDAO{
	Repository repo = new Repository();
	private HashMap<Integer, User> userMap = repo.userMap;
	private HashMap<Integer, Admin> adminMap =  repo.adminMap;
	private HashMap<Integer,Bus> busMap = repo.busMap;
	private HashMap<Integer,Ticket> bookMap= repo.bookMap;
	private HashMap<Integer,Suggestion> suggestionMap = repo.suggestionMap;
	private HashMap<Integer,Available> availMap = repo.availMap;

	@Override
	public Boolean createUser(User user) {
		if(userMap.containsKey(user.getUserId())!=false){
			userMap.put(user.getUserId(), user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean updateUser(User user) {
		if(userMap.containsKey(user.getUserId()) != false){
			userMap.put(user.getUserId(), user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean deleteUser(int user_id, String password) {
		if(userMap.containsKey(user_id)){
			User user = userMap.get(user_id);
			if(user.getUserPassword().equals(password)) {

				userMap.remove(user_id);
				return true;
			}
		}
		return false;
	}


	@Override
	public User loginUser(int user_id, String password) {
		if(userMap.containsKey(user_id)){
			User user=userMap.get(user_id);
			if(user.getUserPassword().equals(password)){
				return user;
			}
		}
		return null;
	}

	@Override
	public User searchUser(int user_id) {
		if(userMap.containsKey(user_id)){
			return userMap.get(user_id);
		}
		return null;
	}

	@Override
	public Boolean createBus(Bus bus) {
		if(busMap.containsKey(bus.getBusId())!=false) {
			busMap.put(bus.getBusId(), bus);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateBus(Bus bus) {
		if(busMap.containsKey(bus.getBusId())) {
			busMap.put(bus.getBusId(), bus);
			return true;
		}
		return false;
	}

	@Override
	public Bus searchBus(int bus_id) {
		if(busMap.containsKey(bus_id)){
			return busMap.get(bus_id);
		}
		return null;
	}

	@Override
	public Boolean deletebus(int bus_id) {
		if(busMap.containsKey(bus_id)){
			busMap.remove(bus_id);
			return true;
		}
		return false;
	}

	@Override
	public Admin adminLogin(int admin_id, String password) {
		if(adminMap.containsKey(admin_id)){
			Admin admin=adminMap.get(admin_id);
			return admin;
		}
		else{
			return null;
		}
	}	

	@Override
	public Ticket bookTicket(Ticket ticket) {

		ticket.setDateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		Integer availableseats= checkAvailability(ticket.getBusId(), ticket.getJourneyDate());
		if (availableseats>=ticket.getNoofSeats()) {
			bookMap.put(ticket.getBookingId(), ticket);
			return ticket;
		}else {

		return null;
		}
	}

	@Override
	public Boolean cancelTicket(int booking_id) {
		if(bookMap.containsKey(booking_id)) {
			bookMap.remove(booking_id);
			return true;
		}
		return false;
	}

	@Override
	public Ticket getTicket(int booking_id) {
		Ticket ticket = null;
		if(bookMap.containsKey(booking_id)) {
			return bookMap.get(booking_id);
		}else{
			return ticket;
		}
	}

	@Override
	public List<Available> checkAvailability(String source, String destination, Date date) {
		List<Available> list = new ArrayList<Available>();
		Available available = null;
		Bus bus=null;
		for(Integer availId:availMap.keySet() ){
			available=availMap.get(availId);
			bus=searchBus(available.getBusId());
			if(bus.getSource().equals(source) &&
					bus.getDestination().equals(destination) && 
					available.getAvailableDate().equals(date)){
				list.add(available);
			}

		}
		return list;
	}


	@Override
	public Integer checkAvailability(int bus_id, Date date) {
		int availSeats = 0;
		for(Integer availId: availMap.keySet()){
			Available available=availMap.get(availId);
			if(bus_id==available.getBusId() && date.equals(available.getAvailableDate())){
				availSeats=available.getAvailableSeats();
			}
		}
		return availSeats;

	}

	@Override
	public Boolean giveFeedback(int userId, String feedback) {
		Suggestion suggest = null;
		if(suggestionMap.containsKey(suggest.getUserid())) {
			suggestionMap.put(suggest.getSuggId(), suggest);
			return true;
		}
		return false;
	}

	@Override
	public List<Suggestion> getAllSuggestions(Suggestion sugg) {
		List<Suggestion> list = new ArrayList<>();
		for(Integer sugId : suggestionMap.keySet()) {
			list.add(sugg);
		}

		return list;
	}

	@Override
	public Boolean setBusAvailability(Available available) {
		if(availMap.containsKey(available.getAvailableId())) {
			availMap.put(available.getAvailableId(), available);
			return true;
		}else {

			return false;
		}
	}
}
