<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "model.Event" %>
<%@page import = "service.EventServiceImp" %>
<%@page import = "service.IEventService" %>
<%@page import = "model.Event" %>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>

	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		
		<meta charset="ISO-8859-1">
		<title>EPS | GetEvent</title>
	</head>

		<header>
			<jsp:include page="header.jsp"></jsp:include>
		</header>
		
		<div id = "container">
			<li class = "list-group-item"><a href = "index.jsp">Home Page</a></li>
		</div>
		
		<body>
		
			<%
				Event event = (Event) request.getAttribute("event");
			%>
		
			<div class = "container">
				<form method = "POST" action = "UpdateEventServlet" class = "form-group">
				<table>
					<tr>
						<td>Event ID</td>
						<td><input type="text" name = "eventID" disabled = "disabled" value = "<%=event.getEventID()%>" class = "form-control"></td>
					</tr>
				
					<tr>
						<td>Event Name</td>
						<td><input type="text" name = "eventName"  value = "<%=event.getEventName()%>" class = "form-control"></td>
					</tr>
					
					<tr>
						<td>Event Date</td>
						<td><input type="text" name = "eventDate" value = "<%=event.getEventDate()%>" class = "form-control"></td>
					</tr>
					
					<tr>
						<td>Event Time</td>
						<td><input type="text" name = "eventTime"  value = "<%=event.getStartTime()%>" class = "form-control"></td>
					</tr>
					
					<tr>
						<td>Event Location</td>
						<td><input type="text" name = "eventLocation"  value = "<%=event.getVenue()%>" class = "form-control"></td>
					</tr>
					
					<tr>
						<td>Max Participants</td>
						<td><input type="text" name = "MaxParticipants"  value = "<%=event.getMaxPrticipants()%>" class = "form-control"></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="hidden" name="eventID" value="<%=event.getEventID()%>" /> 
						<input type="submit" value="Update Event" class="btn btn-primary"/></td>
					</tr>
					
				</table>
				
				</form>
			</div>
			
			<div style = "height : 200px;"></div>
				
		</body>
		
		<footer><jsp:include page="footer.jsp"></jsp:include></footer>
</html>