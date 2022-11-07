<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.loginandboard.overall.dto.MemberInfoDTO" %><%--
  Created by IntelliJ IDEA.
  User: wjswn
  Date: 11/6/2022
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if(session.getAttribute("id")==null || !request.isRequestedSessionIdValid()){
        // 세션이 없을 경우 로그인 창으로 이동
        out.println("<script>alert('로그인이 필요합니다.');");
        out.println("location.href='/login/view';</script>");
        return;
    }
%>
<%
    MemberInfoDTO memberInfo =
            (MemberInfoDTO) request.getAttribute("memberinfo");
%>
<html>
<head>
    <title>Admin_member_info</title>
</head>
<body align=center>
<h2>'<%= memberInfo.getId() %>'님의 개인 정보</h2>
<form name="form" method="post">
    <table align=center border=1>
        <tr><td>아이디 : </td><td><%= memberInfo.getId() %></td></tr>
        <tr><td>비밀번호 : </td><td><%= memberInfo.getPw() %></td></tr>
        <tr><td>이름 : </td><td><%= memberInfo.getName() %></td></tr>
        <tr><td>메일 : </td><td><%= memberInfo.getMail() %></td></tr>
        <tr><td>생일 : </td><td><%= memberInfo.getBirthday() %></td></tr>
        <tr><td colspan=2>
            <input type=submit value="뒤로가기" onclick="javascript: form.action='/admin/member/list'"/>
            <input type=submit value="삭제하기" onclick="javascript: form.action='/admin/member/delete?id=<%=memberInfo.getId()%>'"/></td></tr>
    </table>
</form>
</body>
</html>
