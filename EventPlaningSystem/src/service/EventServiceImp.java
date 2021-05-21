package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import model.Event;
import util.CommonUtil;
import util.DBConnectionUtil;
import util.EventQueryUtil;

public class EventServiceImp implements IEventService{
	
	/*Initialize logger*/
	public static final Logger log = Logger.getLogger(EventServiceImp.class.getName());

	private static Connection connection;
	
	private static Statement statement;
	
	private static PreparedStatement preparedStatement;
	
/*	static {
		//create table or drop table if exist
		try {
			createEventTable();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static PreparedStatement preparedStatement;

	/*
	 * This method will drop Event table if exist and create a new Event table
	 * 
	 * *//*
	public static void createEventTable() throws ParserConfigurationException, SAXException, IOException {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			//drop table if already exist and as per SQL query available in EventQueryUtil
			statement.executeUpdate(EventQueryUtil.dropEventTableQuery());
			
			//create new event table as per sql query available in EvqntQueryUtil
			statement.executeUpdate(EventQueryUtil.createEventTableQuery());
			
		}catch(SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}*/
	
	/*
	 * Add a new event to the Event list in DB
	 * */
	public void addEvent(Event event) {
		String eventID = CommonUtil.generateIDs(getEventIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query for insert data is available in EventQueryUtil*/
			preparedStatement = connection.prepareStatement(EventQueryUtil.insertIntoEventTableQuery());
			connection.setAutoCommit(false);
			
			//Generate EventID
			
			event.setEventID(eventID);
			preparedStatement.setString(1, event.getEventID());
			preparedStatement.setString(2, event.getEventName());			
			preparedStatement.setString(3,event.getEventDate().toString());
			preparedStatement.setString(4, event.getStartTime());
			preparedStatement.setString(5, event.getVenue());
			preparedStatement.setInt(6, event.getMaxPrticipants());
			
			preparedStatement.executeUpdate();
			connection.commit();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		
	}
	
	/*
	 * Retrive the event info based on eventId provided
	 * Method already implemented in actionOnEvent()
	 * @par EventID
	 * @return single Event Info
	 * */
	@Override
	public Event getEventByID(String EventID) {
		
		return actionOnEvent(EventID).get(0);
	}

	/*
	 * Get all list of employee
	 * Method alreday implemented in actionOnEvent()
	 * @return ArrayList<Event>
	 * */
	@Override
	public ArrayList<Event> getEvent() {
		
		return actionOnEvent(null);
	}

	/*
	 * get the updated event
	 * @par EventID
	 * @return Event object
	 * */
	@Override
	public Event updateEvent(String EventID, Event event) {
		/*
		 * Before fetching event it check whether eventID is not null
		 * */
		if (EventID !=null && !EventID.isEmpty()) {
			//update event query will retrieved from EventQueryUtil
			try {
				connection  = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(EventQueryUtil.updateEventQuery());
				
				preparedStatement.setString(1, event.getEventName());
				preparedStatement.setString(2, event.getEventDate());
				preparedStatement.setString(3, event.getStartTime());
				preparedStatement.setString(4, event.getVenue());
				preparedStatement.setInt(5, event.getMaxPrticipants());
				preparedStatement.setString(6, event.getEventID());
				
				preparedStatement.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		//get the updated Event
		return getEventByID(EventID);
	}
	
	/*
	 * Delete an event based on eventId provided
	 * @par EventID
	 * */
	@Override
	public void removeEvent(String EventID) {
		// Before deleting check whether event ID is available
		if(EventID != null && !EventID.isEmpty()) {
			//Remove Event Query will retrieved from EventQueryUtil
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(EventQueryUtil.deleteEventQuery());
				preparedStatement.setString(1, EventID);
				preparedStatement.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			
		}
	}
	
	/*
	 * This method returns array list of event IDs to genaerate the ID of new Event
	 * */
	public ArrayList<String> getEventIDs(){
		
	 ArrayList<String> arrayList = new ArrayList <String>();
	 /*
	  * List of Event ID will be retrieved from EventQueryUtil
	  * */
	
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(EventQueryUtil.getEventIdsQuery());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1));
			}
			
		} catch (SQLException| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			
			/*
			 * closin the prepared statement and database connectivity
			 * */
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
				}
		}	
	 
	return arrayList;
	}
	
	/*
	 * This performs get Event ID and list all Events
	 * 
	 * */
	private ArrayList<Event> actionOnEvent(String eventID){
		ArrayList<Event> eventList = new ArrayList<Event>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			//Before Fetching checks whether eventId is not null
			if(eventID != null && !eventID.isEmpty()) {
				//Get event ID query will ritreived from EventQueryUtil
				
				preparedStatement = connection.prepareStatement(EventQueryUtil.selectEventByIdQuery());
				preparedStatement.setString(1,eventID);
			}
			/*
			 * If event ID is not provided for get Event option Display 
			 * all Events
			 * */
			else {
				preparedStatement  = connection.prepareStatement(EventQueryUtil.selectAllEventQuery());
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Event event = new Event();
				event.setEventID(resultSet.getString(1));
				event.setEventName(resultSet.getString(2));
				event.setEventDate(resultSet.getString(3));
				event.setStartTime(resultSet.getString(4));
				event.setVenue(resultSet.getString(5));
				event.setMaxPrticipants(resultSet.getInt(6));
				
				eventList.add(event);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return eventList;
	}
	
	/*
	 * join an event based on eventId provided
	 * @par EventID
	 * */
	@Override
	public void joinEvent(String EventID) {
		// Before  join check whether event ID is available
		if(EventID != null && !EventID.isEmpty()) {
			//join Event Query will retrieved from joinQueryUtil
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(EventQueryUtil.joinEventQuery());
				preparedStatement.setString(1, EventID);
				preparedStatement.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			
		}
	}
	
	
}
