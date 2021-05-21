package service;

import java.util.ArrayList;
import java.util.logging.*;

import model.Event;

public interface IEventService {
	public static final Logger log = Logger.getLogger(IEventService.class.getName());
	
	/*
	 * Add Events for Event Table*/
	public void addEvent(Event event);
	
	/*
	 * Get a particular Event By ID
	 * input parameter eventID
	 * returns Event*/
	public Event getEventByID(String EventID);
	
	/*
	 * Get a list of all the Events in the system*/
	public ArrayList<Event> getEvent();
	
	/*
	 * Update an existing event data
	 * @parameter EventID
	 * @parameter Event*/
	public Event updateEvent(String EventID, Event event);
	
	/*
	 * Remove exiting event
	 * @param EventID*/
	public void removeEvent(String EventID);
	
	/*
	 * join Event event
	 * @param EventID*/
	public void joinEvent(String EventID);
}

