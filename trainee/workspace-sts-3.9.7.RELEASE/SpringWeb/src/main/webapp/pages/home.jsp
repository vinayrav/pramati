<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="homes">
<input type="text" name="bid"><br>
<input type="text" name="bname"><br>
<input type="text" name="blang"><br>

<input type="submit"><br>
${obj.bid},${obj.bname},${obj.blang}
</form>



</body>
</html>