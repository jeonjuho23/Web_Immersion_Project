<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: wjswn
  Date: 11/6/2022
  Time: 11:03 PM
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
<html>
<head>
    <title>Board_write</title>
    <script language="javascript">
        function addboard(){
            boardform.submit();
        }
    </script>
</head>
<body>
<!-- 게시판 등록 -->
<form action="/board/add" method="post"
      enctype="multipart/form-data" name="boardform">
    <table cellpadding="0" cellspacing="0">
        <tr align="center" valign="middle">
            <td colspan="5">MVC 게시판</td>
        </tr>
        <tr>
            <td style="font-family:돋음; font-size:12" height="16">
                <div align="center">글쓴이</div>
            </td>
            <td>
                <input name="BOARD_NAME" type="text" size="10" maxlength="10"
                       value=""/>
            </td>
        </tr>
        <tr>
            <td style="font-family:돋음; font-size:12" height="16">
                <div align="center">비밀번호</div>
            </td>
            <td>
                <input name="BOARD_PASS" type="password" size="10" maxlength="10"
                       value=""/>
            </td>
        </tr>
        <tr>
            <td style="font-family:돋음; font-size:12" height="16">
                <div align="center">제 목</div>
            </td>
            <td>
                <input name="BOARD_SUBJECT" type="text" size="50" maxlength="100"
                       value=""/>
            </td>
        </tr>
        <tr>
            <td style="font-family:돋음; font-size:12">
                <div align="center">내 용</div>
            </td>
            <td>
                <textarea name="BOARD_CONTENT" cols="67" rows="15"></textarea>
            </td>
        </tr>
        <tr>
            <td style="font-family:돋음; font-size:12">
                <div align="center">파일 첨부</div>
            </td>
            <td>
                <input name="BOARD_FILE" type="file"/>
            </td>
        </tr>
        <tr bgcolor="cccccc">
            <td colspan="2" style="height:1px;">
            </td>
        </tr>
        <tr><td colspan="2">&nbsp;</td></tr>
        <tr align="center" valign="middle">
            <td colspan="5">
                <a href="javascript:addboard()">[등록]</a>&nbsp;&nbsp;
                <a href="javascript:history.go(-1)">[뒤로]</a>
            </td>
        </tr>
    </table>
</form>
<!-- 게시판 등록 -->
</body>
</html>
