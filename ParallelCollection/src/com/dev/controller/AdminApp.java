package com.dev.controller;

import java.util.List;
import java.util.Scanner;

import com.dev.beans.Admin;
import com.dev.beans.Bus;
import com.dev.beans.Suggestion;
import com.dev.beans.User;
import com.dev.service.Service;
import com.dev.service.ServiceImpl;

public class AdminApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Admin admin = new Admin();
		User user = new User();
		Bus bus = new Bus();
		Service service = new ServiceImpl();
	
		System.out.println("Enter Admin id:");
		int adminid = Integer.parseInt(sc.next());
		System.out.println("Enter Admin password:");
		String password = sc.next();
		boolean b = service.adminLogin(adminid,password);
		if(b) {
			System.out.println("Login Succesful");
			boolean bo = true ;
			while(bo) {
				System.out.println("1. Search User"+"\n"
						+ "2.Create Bus"+"\n"
						+ "3.Update Bus"+"\n"
						+ "4.Delete Bus"+"\n"
						+ "5.View Feedback"+"\n"
						+ "6.Exit");
				int ad = Integer.parseInt(sc.next());

				switch(ad){
				case 1 :
					System.out.println("Enter UserID");
					int userid = Integer.parseInt(sc.next());
					User users = service.searchUser(userid);
					if(users != null) {
						System.out.println(users);
					}
					else {
						System.out.println("Fail to Search");
					}
					break;
				case 2 :
					System.out.println("Enter Bus Id");
					bus.setBusId(Integer.parseInt(sc.next()));
					System.out.println("Enter BusName");
					bus.setBusName(sc.next());

					System.out.println("Enter Bus type");
					bus.setBusType(sc.next());

					System.out.println("Enter Source");
					bus.setSource(sc.next());
					System.out.println("Enter Destination");
					bus.setDestination(sc.next());

					System.out.println("Enter Total Seats");
					bus.setTotalSeats(Integer.parseInt(sc.next()));
					System.out.println("Enter Price");
					bus.setPrice(Double.parseDouble(sc.next()));

					boolean creb = service.createBus(bus);
					if(creb) {
						System.out.println("Bus created");
					}
					else {
						System.out.println("Fail to Create");
					}
					break;

				case 3:
					System.out.println("Enter Bus Id");
					bus.setBusId(Integer.parseInt(sc.next()));
					System.out.println("Enter New BusName");
					bus.setBusName(sc.next());
					System.out.println("Enter New Source");
					bus.setSource(sc.next());
					System.out.println("Enter New Destination");
					bus.setDestination(sc.next());
					System.out.println("Enter New Bus type");
					bus.setBusType(sc.next());
					System.out.println("Enter New Total Seats");
					bus.setTotalSeats(Integer.parseInt(sc.next()));
					System.out.println("Enter New Price");
					bus.setPrice(Double.parseDouble(sc.next()));

					boolean upbus = service.updateBus(bus);
					if(upbus)
					{
						System.out.println("Bus Successfully Updated");
					}
					else {
						System.out.println("Fail to Update");
					}
					break;
				case 4 : 
					System.out.println("Enter Bus Id");
					int busid = Integer.parseInt(sc.next());
					boolean delbus = service.deletebus(busid);
					if(delbus)
					{
						System.out.println("Bus Successfully Deleted");
					}
					else {
						System.out.println("Fail to Delete Bus");
					}
					break;
				case 5: Suggestion sugg = new Suggestion();
				List<Suggestion> li = service.getAllSuggestions(sugg);
				for(Suggestion s : li)
				{
					System.out.println(s);
				}

				break;
				case 6 :bo = false;
				break;
				default :
					System.out.println("Incorrect Option");
					break;
				}


			}

		}

		else {
			System.out.println("Login Fail");
		}   



	}

}
