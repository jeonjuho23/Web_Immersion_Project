<%--
  Created by IntelliJ IDEA.
  User: wjswn
  Date: 11/6/2022
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body background="https://juhotest.w3spaces.com/aa.jpg" align=center>
<h2>LoginForm</h2>
<form name="form" method="post">
    <table align=center border=1>
        <tr>
            <td>ID:</td>
            <td><input type=text name=id></td>
        </tr>
        <tr>
            <td>PW:</td>
            <td><input type=text name=pw></td>
        </tr>
        <tr>
            <td colspan=2>
                <input type=submit value="로그인" onclick="javascript: form.action='/login/';">
                <input type=submit value="회원가입" onclick="javascript: form.action='/join/view';">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
