<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <form action="/hw/s-login-check">
        #아이디 : <input id="id" type="text" name="id"><br>
        #비밀번호 : <input id="pw" type="password" name="pw">

        <label>
            <button type="submit">로그인</button>
        </label>
    </form>
</body>
</html>