<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
        </head>

        <body>
            <h1 id="login-result">${result}</h1>

            <!-- <c:if test = ${result == 'f-id'}아이디가 존재...</c:if> -->
            <a href="/hw/s-login-form">다시 로그인하기</a>
        </body>


        </html>