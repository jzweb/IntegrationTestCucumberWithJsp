<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Report</title>
</head>
<body>
	<h3>List of Person Registered</h3>
	<label>Total: ${total}</label>
	<p>Find a person </p>
	<form action="/report" method="POST">
		<input type="text" placeholder="insert person id" name="personId">
		<input type="submit" value="Find">
	</form>
	
	<ul>
		<c:forEach items="${personList}" var="person">
	       <li>
	  			<label>Id: </label><c:out value="${person.id}"></c:out><br>
	       		<label>Fullname: </label><c:out value="${person.name}, ${person.lastname}"></c:out><br>
	       </li><br>	
		</c:forEach>
	</ul>
	
	<br>
	<p><a href="/">Return</a></p>

</body>
</html>