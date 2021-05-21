package util;

/*
 * EventQueryUtil class use to implement functions to return querie
 * needed for Event Class
 * */
public class EventQueryUtil {
	
	/*
	 * This Method will return the query for creating table Event
	 * @return String
	 */
	public static String createEventTableQuery() {
		String query = "CREATE TABLE event("+
						"eventId varchar(10) not null,"+
						"eventName varchar(20),"+
						"eventDate date,"+
						"eventTime time,"+
						"location varchar(50),"+
						"maxParticipants int"+
						"primary key(eventId)"+
						")";
		return query;
	}
	
	/*
	 *This returns the query for drop table if exist 
	 *@return String
	 * */
	public static String dropEventTableQuery() {
		String query = " DROP TABLE IF EXISTS event ";
		return query;
	}
	
	/*
	 * This returns the insert query for Event Table
	 * @return String
	 * */
	public static String insertIntoEventTableQuery() {
		String query = "insert into event(eventID,eventName,eventDate,eventTime,location,maxParticipants) values(?,?,?,?,?,?)";
		return query;
	}
	
	/*
	 * Returns the query for select a particular Event
	 * @returns String
	 * */
	public static String selectEventByIdQuery() {
		String query  = "select  * from event where event.eventID = ?";
		return query;
	}
	
	/*
	 * Select all events Query
	 * @return String
	 * */
	public static String selectAllEventQuery() {
		String query = "select * from event";
		return query;
	}
	
	/*
	 * returns query for select all events
	 * @return String
	 * */
	public static String deleteEventQuery() {
		String query = "delete from event where event.eventID = ?";
		return query;
	}
	
	/*
	 * return uodate query for event
	 * @retrn event
	 * */
	public static String updateEventQuery() {
		String query = "update event set eventName = ?, eventDate = ?, eventTime = ?, location = ?, maxParticipants = ? where eventID = ?";
		return query;
	}
	
	/*
	 * get EventIds Query
	 * */
	public static String getEventIdsQuery() {
		String query = "select e.eventID from event as e";
		return query;
	}
	
	/*
	 * Returns the query for join a particular Event
	 * @returns String
	 * */
	public static String joinEventByIdQuery() {
		String query  = "join  * from event where event.eventID = ?";
		return query;
	}
}






