<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.example.loginandboard.board.dto.BoardDTO" %><%--
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
    BoardDTO board = (BoardDTO)request.getAttribute("boarddata");
%>
<html>
<head>
    <title>Board_view</title>
</head>
<body>
<!-- 게시판 수정 -->
<table cellpadding="0" cellspacing="0">
    <tr align="center" valign="middle">
        <td colspan="5">MVC 게시판</td>
    </tr>

    <tr>
        <td style="font-family:돋음; font-size:12" height="16">
            <div align="center">제 목&nbsp;&nbsp;</div>
        </td>

        <td style="font-family:돋음; font-size:12">
            <%=board.getBOARD_SUBJECT()%>
        </td>
    </tr>

    <tr bgcolor="cccccc">
        <td colspan="2" style="height:1px;">
        </td>
    </tr>

    <tr>
        <td style="font-family:돋음; font-size:12">
            <div align="center">내 용</div>
        </td>
        <td style="font-family:돋음; font-size:12">
            <table border=0 width=490 height=250 style="table-layout:fixed">
                <tr>
                    <td valign=top style="font-family:돋음; font-size:12">
                        <%=board.getBOARD_CONTENT() %>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td style="font-family:돋음; font-size:12">
            <div align="center">첨부파일</div>
        </td>
        <td style="font-family:돋음; font-size:12">
            <%if(!(board.getBOARD_FILE()==null)){ %>
            <a href="./boardupload/<%=board.getBOARD_FILE()%>">
                <%=board.getBOARD_FILE() %>
            </a>
            <%} %>
        </td>
    </tr>

    <tr bgcolor="cccccc">
        <td colspan="2" style="height:1px;"></td>
    </tr>
    <tr><td colspan="2">&nbsp;</td></tr>

    <tr align="center" valign="middle">
        <td colspan="5">
            <font size=2>
                <a href="/board/reply/view?num=<%=board.getBOARD_NUM() %>">
                    [답변]
                </a>&nbsp;&nbsp;
                <a href="/board/modify/view?num=<%=board.getBOARD_NUM() %>">
                    [수정]
                </a>&nbsp;&nbsp;
                <a href="/board/delete/view?num=<%=board.getBOARD_NUM() %>">
                    [삭제]
                </a>&nbsp;&nbsp;
                <a href="/board/list">[목록]</a>&nbsp;&nbsp;
            </font>
        </td>
    </tr>
</table>
<!-- 게시판 수정 -->
</body>
</html>
