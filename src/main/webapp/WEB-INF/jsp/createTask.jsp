<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-// W3C// DTD HTML 4.01  
 Transitional// EN" "http:// www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html;  
 charset=UTF-8"> 
<title>Create Task</title> 
</head> 
<body> 	
	<p>User: ${Username} </p>
	<h1>Create Task</h1>
	<form name='create' action="createNewTask" method='POST'>
		<p>Task Name: <input type="text" style="width: 200px" name="taskName"></p>
		<p>Start Date: <input type="date" style="width: 200px" name="startDate"></p>
		<p>End Date: <input type="date" style="width: 200px" name="endDate"></p>
		<p>Severity:
		<select name = "severity">
            <option value = "low" selected>Low</option>
            <option value = "medium">Medium</option>
            <option value = "high">High</option>
         </select> </p>
		<p>Description: </p> 
		<textarea name="description" rows="5" style="width:500px;"></textarea><br/><br/>
		<input type="hidden" name="username" value="${Username}">
		<input name="submit" type="submit" value="submit" style="width: 100px"><br/><br/>
	</form>
</body> 
</html> 