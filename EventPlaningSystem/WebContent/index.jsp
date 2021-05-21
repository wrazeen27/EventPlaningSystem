
<%@ page language="java" contentType="text/html; chars
	<link rel="stylesheet" href="https://stackpatet=UTF-8" 
	pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
h.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		
	
	<meta charset="UTF-8">
		<title>Event Planing System</title>
	</head>
	
	<header>
		<jsp:include page="/jsps/header.jsp"></jsp:include>
		</br></br>
	</header>
	
	<body>
			<div class= "container ">
				<form  method = "POST" action = "jsps/createEvent.jsp" class = "form-group">
					<input type="submit" name="newEvent" value = "Create New Event" class = "btn btn-secondary btn-block"></input>
				</form>
				
				<form method = "POST" action = "ListEventServlet" class = "form-group">
					<input type="submit" name="selector" value = "View Event" class = "btn btn-secondary btn-block"/>
				</form>
				
				<form method = "POST" action = "JoinEvent.jsp" class = "form-group">	
					<input type="submit" name="selector" value = "Join Events" class = "btn btn-secondary btn-block"></input>
				</form>
				
				<form method = "POST" action = "EmployeeManagement.jsp" class = "form-group">
					<input type="submit" name="selector" value = "Employee Management" class = "btn btn-secondary btn-block"></input>
				</form>
			</div>
			
			<div style = "height : 200px;"></div>
			

	</body>
	
	<footer><jsp:include page="/jsps/footer.jsp"></jsp:include></footer>
	
</html>