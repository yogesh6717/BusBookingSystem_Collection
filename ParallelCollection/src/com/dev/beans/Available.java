package com.dev.beans;


public class Available {
	private int availableId;
	private String availableDate;
	private int availableSeats;
	private int busId;
	public int getAvailableId() {
		return availableId;
	}
	public void setAvailableId(int availableId) {
		this.availableId = availableId;
	}
	public String getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	@Override
	public String toString() {
		return "Available [availableId=" + availableId + ", availableDate=" + availableDate + ", availableSeats="
				+ availableSeats + ", busId=" + busId + "]";
	}



}
