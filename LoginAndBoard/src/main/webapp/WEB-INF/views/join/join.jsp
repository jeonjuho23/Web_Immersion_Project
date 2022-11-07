<%--
  Created by IntelliJ IDEA.
  User: wjswn
  Date: 11/6/2022
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<script language="javascript">
    // 츨생년도
    function numberch(targetStr) {
        const regexr = /^\d+$/;
        return regexr.test(targetStr); // true
    }

    // 아이디, 비밀번호로 사용 가능한지 검사(4~12자리 영문자,숫자만)
    function idPw(targetStr) {
        const regexr = /^[A-Za-z0-9]{4,10}$/;
        return regexr.test(targetStr); // true
    }

    // 비밀번호 확인
    function pwCheck(targetStr, checkStr) {
        return targetStr == checkStr;
    }

    // 메일주소
    function mailch(targetStr) {
        const regexr =
            /^[0-9a-zA-Z][0-9a-zA-Z]*@[0-9a-zA-Z][0-9a-zA-Z]*.[a-zA-Z][a-zA-Z]*$/;
        return regexr.test(targetStr); // true
    }

    // 이름, 자기소개 (한 글자 이상)
    function namech(targetStr) {
        const regexr = /^[가-히]+/;
        return regexr.test(targetStr); // true
    }


    function validation() {
        var id = document.getElementById("id").value;
        var pw = document.getElementById("pw").value;
        var pwcheck = document.getElementById("pwcheck").value;
        var mail = document.getElementById("mail").value;
        var name = document.getElementById("name").value;
        var birth = document.getElementById("birth").value;

        if (!idPw(id)) {
            // 아이디 유효성 실패
            alert("아이디를 다시 입력해주세요.");
            return false;
        } else if (!idPw(pw)) {
            // 비밀번호 유효성 실패
            alert("비밀번호를 다시 입력해주세요.");
            return false;
        } else if (!pwCheck(pw, pwcheck)) {
            // 비밀번호 확인 실패
            alert("비밀번호 확인을 다시 입력해주세요.");
            return false;
        } else if (!mailch(mail)) {
            // 이메일 유호성 실패
            alert("이메일을 다시 입력해주세요.");
            return false;
        } else if (!namech(name)) {
            // 이름 유효성 실패
            alert("이름을 다시 입력해주세요.");
            return false;
        } else if (!numberch(birth)) {
            // 출생년도 유효성 실패
            alert("출생년도를 다시 입력해주세요.");
            return false;
        } else {
            // 모든 유효성 검사 성공
            return true;
        }
    }
</script>
<html>
<head>
    <title>Join</title>
</head>
<body background="https://juhotest.w3spaces.com/aa.jpg">
<form action="/join/" name="form" onsubmit="return validation()" method="post">
    <table align="center" border="1" rules="all">
        <tr bgcolor="#FFB291">
            <th align="center" colspan="6">회원 기본 정보</th>
        </tr>
        <tr>
            <th align="center" bgcolor="#FFDAB9">아이디:</th>
            <td>
                <input type="text" name="id" id="id" size="20" /> 4~12자의 영문 대소문자와
                숫자로만 입력
            </td>
        </tr>
        <tr>
            <th align="center" bgcolor="#FFDAB9">비밀번호:</th>
            <td>
                <input type="text" name="pw" id="pw" size="20" /> 4~12자의 영문 대소문자와
                숫자로만 입력
            </td>
        </tr>
        <tr>
            <th align="center" bgcolor="#FFDAB9">비밀번호확인:</th>
            <td><input type="text" id="pwcheck" size="20" /></td>
        </tr>
        <tr>
            <th align="center" bgcolor="#FFDAB9">메일주소:</th>
            <td><input type="text" name="mail" id="mail" size="25" /> 예) id@domain.com</td>
        </tr>
        <tr>
            <th align="center" bgcolor="#FFDAB9">이름:</th>
            <td><input type="text" name="name" id="name" size="25" /></td>
        </tr>
        <tr>
            <th align="center" colspan="6" bgcolor="#FFB291">개인신상정보</th>
        </tr>
        <tr>
            <th align="center" bgcolor="#FFDAB9">생일:</th>
            <td>
                <input type="text" name="birth" id="birth" size="10" />년&nbsp;
                <select name="month" id="month">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option></select
                >월&nbsp;
                <select name="day" id="day">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option></select
                >일
            </td>
        </tr>
    </table>
    <br />
    <table align="center">
        <tr>
            <td>
                <input align="center" type="submit" value="회원 가입" />
            </td>
            <td>&nbsp;</td>
            <td><input align="center" type="reset" value="다시 입력" /></td>
        </tr>
    </table>
</form>
</body>
</html>
