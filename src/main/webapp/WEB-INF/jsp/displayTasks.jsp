<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-// W3C// DTD HTML 4.01  
 Transitional// EN" "http:// www.w3.org/TR/html4/loose.dtd"> 
 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html;  
 charset=UTF-8"> 
<title>User's Tasks</title> 
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head> 
<body> 	
	<p>User: ${User.name} </p>

	
	<center>
	<h2>Tasks</h2>
	<table>
    	<tr><th>Task #</th><th>Name</th><th>Start Date</th><th>End Date</th><th>Severity</th><th>Description</th></tr>
		<c:forEach items="${Tasks}" var="task" varStatus="count">
		<tr id="${count.index}">
    		<td>${task.getName()}</td>
        	<td>${task.getStartDate()}</td>
        	<td>${task.getEndDate()}</td>
        	<td>${user.getSeverity()}</td>
        	<td>${user.getDescription()}</td>
    		</tr>
		</c:forEach>
	</table>
	<br/>
	<form name='create' action="CreateTask" method='POST'>
		<input type="hidden" name="username" value="${User.name}">
		<input name="CreateTask" type="submit" value="Create a New Task" style="width: 200px">
	</form>
	<form name='update' action="UpdateTask" method='POST'>
		<p>Task # to update: <input type="text" style="width: 10px" name="taskNum">
		<input type="hidden" name="username" value="${User.name}">
		<input name="UpdateTask" type="submit" value="Update a Task" style="width: 200px"></p>
	</form>
	<form name='update' action="DeleteTask" method='POST'>
		<p>Task # to delete: <input type="text" style="width: 10px" name="taskNum">
		<input type="hidden" name="username" value="${User.name}">
		<input name="DeleteTask" type="submit" value="Delete a Task" style="width: 200px"></p>
	</form>
	</center>


</body> 
</html> 