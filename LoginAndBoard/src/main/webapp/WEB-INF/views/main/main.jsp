<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: wjswn
  Date: 11/6/2022
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    if(session.getAttribute("id")==null || !request.isRequestedSessionIdValid()){
        // 세션이 없을 경우 로그인 창으로 이동
        out.println("<script>alert('로그인이 필요합니다.');");
        out.println("location.href='/login/view';</script>");
        return;
    }
%>
<html>
<head>
    <title>Main</title>
</head>
<body align=center>
<h2><%=session.getAttribute("id") %> 님 환영합니다!</h2>
<form name="form" method="post">
    <%
        if(((String)session.getAttribute("id")).equals("admin")){
            // 관리자 모드 로그인 시
    %>
    <a href="/admin/member/list">관리자 모드로 이동하기</a>
    <%
        }
    %>
    <input type="submit" value="로그아웃" onclick="javascript: form.action='/login/logout'"/>
    <input type="submit" value="게시판" onclick="javascript: form.action='/board/list'"/>
</form>
</body>
</html>
