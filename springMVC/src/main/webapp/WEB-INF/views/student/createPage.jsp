<%--
  Created by IntelliJ IDEA.
  User: wjswn
  Date: 11/3/2022
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
createPage.jsp
<br/>
<%
    String conPath = request.getContextPath();
%>

<form action="student/create" method="post">
    이름 : <input type="text" name="name" value="${student.name}">
    아이디 : <input type="text" name="id" value="${student.id}">
    <input type="submit">
</form>

</body>
</html>
