<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: wjswn
  Date: 11/6/2022
  Time: 11:02 PM
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
    int num=Integer.parseInt(request.getParameter("num"));
%>
<html>
<head>
    <title>Board_delete</title>
</head>
<body>
<form name="deleteForm" action="/board/delete?num=<%=num %>"
      method="post">
    <table border=1>
        <tr>
            <td>
                <font size=2>글 비밀번호 : </font>
            </td>
            <td>
                <input name="BOARD_PASS" type="password">
            </td>
        </tr>
        <tr>
            <td colspan=2 align=center>
                <a href="javascript:deleteForm.submit()">삭제</a>
                &nbsp;&nbsp;
                <a href="javascript:history.go(-1)">돌아가기</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
