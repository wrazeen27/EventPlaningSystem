<%@page import = "model.Event" %>
<%@page import = "service.EventServiceImp" %>
<%@page import = "service.IEventService" %>
<%@page import = "model.Event" %>
<%@page import = "java.util.ArrayList" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href ="Style.css"/>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		
		<meta charset="ISO-8859-1">
		<title>EPS | Events</title>
	</head>

	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	
	<div id = "container">
		<li class = "list-group-item"><a href = "index.jsp">Home Page</a></li>
	</div>
	
	<body>
	<div class = "container">
 		<div align = "Center" id = "eventList">
 			<table class = "table table-striped table-responsive table-hover table-striped">
 				<h2>List Of Events</h2>
 				<tr>
 					<th>Event ID </th>
 					<th>Event Name</th>
 					<th>Event Date </th>
 					<th>Event Time</th>
 					<th>Event Loaction</th>
 					<th>Maximum Participants</th>
 				</tr>
 				
 				<%IEventService iEventService = new EventServiceImp();
 				ArrayList<Event> arrayList = new ArrayList<Event>();
 						arrayList = iEventService.getEvent();
 				
 				for(Event event:arrayList){
 				%>
 				<tr>
	 				<td> <%=event.getEventID() %> </td>
	 				<td> <%=event.getEventName() %> </td>
	 				<td> <%=event.getEventDate() %> </td>
	 				<td> <%=event.getStartTime() %> </td>
	 				<td> <%=event.getVenue() %> </td>
	 				<td> <%=event.getMaxPrticipants() %> </td>
	 				<td>
	 					<form method="POST" action = "GetEventServlet">
	 						<input type = "hidden" name = "eventID" value = "<%= event.getEventID() %>" ></input>	 					
	 						<input type = "submit" value = "Update" class = "btn btn-primary" ></input>
	 					</form>
	 				</td>
	 				
	 				<td>
	 					<form method="POST" action = "DeleteEventServlet">
	 						<input type = "hidden" name = "eventID" value = "<%= event.getEventID() %>" ></input>	 					
	 						<input type = "submit" value = "Delete" class = "btn btn-danger" ></input>
						</form>
	 				</td>
 				</tr>
 		
 				<%
 				}
 				%>
 				
 			</table>
 			</div>
 		</div>
 		
 		<div style = "height : 200px;"></div>

	</body>
	
	<footer><jsp:include page="footer.jsp"></jsp:include></footer>
</html>