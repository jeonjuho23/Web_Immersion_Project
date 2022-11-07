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
    <title>Board_modify</title>
    <script type="text/javascript">
        function modifyboard(){
            modifyform.submit();
        }
    </script>
</head>
<body>
<!-- 게시판 수정 -->
<form action="/board/modify/" method="post" name="modifyform">
    <input type="hidden" name="BOARD_NUM" value=<%=board.getBOARD_NUM() %>>
    <table cellpadding="0" cellspacing="0">
        <tr align="center" valign="middle">
            <td colspan="5">MVC 게시판</td>
        </tr>
        <tr>
            <td height="16" style="font-family:돋음; font-size:12">
                <div align="center">제 목</div>
            </td>
            <td>
                <input name="BOARD_SUBJECT" size="50" maxlength="100"
                       value="<%=board.getBOARD_SUBJECT()%>">
            </td>
        </tr>
        <tr>
            <td style="font-family:돋음; font-size:12">
                <div align="center">내 용</div>
            </td>
            <td>
			<textarea name="BOARD_CONTENT" cols="67" rows="15">
			<%=board.getBOARD_CONTENT() %>
			</textarea>
            </td>
        </tr>
        <%if(!(board.getBOARD_FILE()==null)){ %>
        <tr>
            <td style="font-family:돋음; font-size:12">
                <div align="center">파일 첨부</div>
            </td>
            <td>
                &nbsp;&nbsp;<%=board.getBOARD_FILE() %>
            </td>
        </tr>
        <%} %>
        <tr>
            <td height="16" style="font-family:돋음; font-size:12">
                <div align="center">비밀번호</div>
            </td>
            <td>
                <input name="BOARD_PASS" type="password">
            </td>
        </tr>

        <tr bgcolor="cccccc">
            <td colspan="2" style="height:1px;">
            </td>
        </tr>
        <tr><td colspan="2">&nbsp;</td></tr>

        <tr align="center" valign="middle">
            <td colspan="5">
                <font size=2>
                    <a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
                    <a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
                </font>
            </td>
        </tr>
    </table>
</form>
<!-- 게시판 수정 -->
</body>
</html>
