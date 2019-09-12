<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Registration</title>
</head>
<body>
	<h3>Person Registration Form</h3>
	<form action="/registration" method="POST">
		<input type="text" placeholder="person name" name="name" ><br>
		<input type="text" placeholder="person lastname" name="lastname"><br>
		<input type="submit">
	</form>
	<p style="color:#EF5836">${message}</p>
	<br>
	<p><a href="/">Return</a></p>

</body>
</html>