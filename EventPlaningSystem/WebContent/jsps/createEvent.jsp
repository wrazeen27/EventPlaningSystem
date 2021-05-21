<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		
	<meta charset="UTF-8">
	<title>EPS | Create Event</title>
	</head>
	
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	
	<div id = "Nav">
		<li class = "list-group-item"><a href = "../index.jsp">Home Page</a></li></br>
	</div>
	
	<body>
		<div class = "container">
			<form action = "../AddEventServlet" method = "POST" class = "form-group">
				<table>
				
					<tr>
						<td>Event Name</td>
						<td><input type="text" name = "eventName" class = "form-control"></td>
					</tr>
					
					<tr>
						<td>Date</td>
						<td><input type="text" name = "eventDate" placeholder = "dd/mm/yyyy" class = "form-control"></td>
					</tr>
					
					<tr>
						<td>Starting Time</td>
						<td><input type ="text" name = "eventTime" class = "form-control"/></td>
					</tr>
					
					<tr>
						<td>Venue</td>
						<td><input type ="text" name = "location" class = "form-control"/></td>
					</tr>
					
					<tr>
						<td>Maximum Participants</td>
						<td><input type ="text" name = "maxParticipants" class = "form-control"/></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" value="Add Event" class="btn btn-success" /> </td>
					</tr>
					<tr>	
						<td colspan="2"><input type="reset" value="Reset" class="btn btn-info" /></td>
					</tr>
				</table>
			</form>
		</div>
		
		<div style = "height : 200px;"></div>
		
	</body>
	
	<footer><jsp:include page="footer.jsp"></jsp:include></footer>
	
	</html>