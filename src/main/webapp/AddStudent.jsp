<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Student DEtails:-</h1>
<form action="add-student" method="post">
<input type="number" placeholder="Enter StudentId" name="studentId"> <br>
<input type="text" placeholder="Enter StudentName" name="studentName"> <br>
<input type="text" placeholder="Enter StudentEmail" name="studentEmail"> <br>

<input type="number" placeholder="Enter StudentAge" name="studentAge"> <br>
<input type="text" placeholder="Enter StudentCourse" name="studentCourse"> <br>
<input type="text" placeholder="Enter StudentCity" name="studentCity"> <br>
<input type ="submit" value="ADD">

</form>

</body>
</html>