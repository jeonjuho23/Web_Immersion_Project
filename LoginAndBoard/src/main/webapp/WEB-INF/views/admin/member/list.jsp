<%--
  Created by IntelliJ IDEA.
  User: wjswn
  Date: 11/6/2022
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%
    if(session.getAttribute("id")==null || !request.isRequestedSessionIdValid()){
        // 세션이 없을 경우 로그인 창으로 이동
        out.println("<script>alert('로그인이 필요합니다.');");
        out.println("location.href='/login/view';</script>");
        return;
    }
%>
<%
    List memberList = request.getParameter("memberList");
%>
<html>
<head>
    <title>Admin_member_list</title>
</head>
<body align=center>
<h2>유저 리스트</h2><br><br>
<table align=center border=1>
    <%
        for(int i=0;i<memberList.size();i++){
            out.println("<tr><td>"+(i+1)+"</td>");
            out.println("<td><a href='/admin/member/info?id="+memberList.get(i)
                    +"'/>"+memberList.get(i)+"</td></tr>");
        }
    %>
</table>
<br><br><br>
<form action="/main/" method="post">
    <input type=submit value="Main으로 가기"/>
</form>
</body>
</html>
