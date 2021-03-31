<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-// W3C// DTD HTML 4.01  
 Transitional// EN" "http:// www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html;  
 charset=UTF-8"> 
<title>Home</title> 
</head> 
<body> 	
	<p>User: ${Username} </p>
	<h1>Delete Task</h1>
	<p>Are you sure you want to Delete "${Task.getName()}"</p>
	<form name='delete' action="deleteTask" method='POST'>
		<input type="radio" id="No" name="choice" value="No" checked>No
		<input type="radio" id="Yes" name="choice" value="Yes">Yes
		<input type="hidden" name="username" value="${Username}">
		<input type="hidden" name="username" value="${TaskNum}">
		<br/><br/>
		<input type="submit" style="width: 100px">
	</form>
</body> 
</html> 