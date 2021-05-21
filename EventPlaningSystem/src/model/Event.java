package model;

import java.util.Date;

public class Event {
	/*
	 * Declaring Getters And Setters for Event Class
	 * */
	private String EventID;
	private String EventName;
	private String EventDate;
	private String startTime;
	private String location;
	private int maxPrticipants;
	
	/*
	 * Getters and Setters for Event class variables
	 * */
	
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getVenue() {
		return location;
	}
	public void setVenue(String venue) {
		this.location = venue;
	}
	
	public int getMaxPrticipants() {
		return maxPrticipants;
	}
	public void setMaxPrticipants(int maxPrticipants) {
		this.maxPrticipants = maxPrticipants;
	}
	
	public String getEventID() {
		return EventID;
	}
	public void setEventID(String eventID) {
		EventID = eventID;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public void setEventDate(String eventDate) {
		this.EventDate = eventDate;
	}
	public String getEventDate() {
		return EventDate;
	}
}
