<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">     
<label for="username">Username:</label>
<input type="text" id="username" name="username"><br>
<label for="password">Password:</label>
<input type="password" id="password" name="password"><br>
 <input name="submit" type="submit" value="submit"><br>
 New User?
 <a href="/register.jsp">SignUp</a>
</form>
</body>
</html>