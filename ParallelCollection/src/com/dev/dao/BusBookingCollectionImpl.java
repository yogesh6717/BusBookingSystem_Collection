package com.dev.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dev.beans.Admin;
import com.dev.beans.Bus;
import com.dev.beans.Suggestion;
import com.dev.beans.Ticket;
import com.dev.beans.User;
import com.dev.repository.Repository;

public class BusBookingCollectionImpl implements BusBookingDAO{
	Repository repo = new Repository();
	private HashMap<Integer, User> db = repo.usersInfo;
	private HashMap<Integer, Admin> ad =  repo.adminInfo;

		@Override
		public Boolean createUser(User user) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean updateUser(User user) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean deleteUser(int user_id, String password) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User loginUser(int user_id, String password) {
			// TODO Auto-generated method stub
			
			return null;
		}

		@Override
		public User searchUser(int user_id) {
			User user = null;
			if(db.containsKey(user_id)) {
//			Iterator it = db.entrySet().iterator();
//			while (it.hasNext()) {
//		        Map.Entry pair = (Map.Entry)it.next();
//		        if(pair.getKey().equals(user_id)){
//		        	return (User)pair.getValue();
				return db.get(user_id);
		        }
			else {
				return null;
			}
		    }
			

		

		@Override
		public Boolean createBus(Bus bus) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean updateBus(Bus bus) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Bus searchBus(int bus_id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean deletebus(int bus_id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean adminLogin(int admin_id, String password) {
			Admin admin = new Admin();
			if(ad.containsKey(admin_id) && ad.containsValue(password))
			{
			return true;
			}else {
				return false;
			}
		}

		@Override
		public Ticket bookTicket(Ticket ticket) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean cancelTicket(int booking_id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Ticket getTicket(int booking_id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Bus> checkAvailability(String source, String destination, Date date) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Integer checkAvailability(int bus_id, Date date) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean giveFeedback(int userId, String feedback) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Suggestion> getAllSuggestions(Suggestion sugg) {
			// TODO Auto-generated method stub
			return null;
		}

}
