<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <link rel="stylesheet" href="/assets/css/list.css">
        </head>

        <body>

            <div id="wrap">
                <h1>${s.name}님의 성적 정보 수정</h1>
                <form action="/score/endchange" method="post">
                    <input type="hidden" name="stuNum" value="${s.stuNum}">
                    <ul>
                        <li># 국어: <input type="text" name="kor" value="${s.kor}"></li>
                        <li># 영어: <input type="text" name="eng" value="${s.eng}"></li>
                        <li># 수학: <input type="text" name="math" value="${s.math}"></li>
                    </ul>
                    <a href="/score/list">목록</a>
                    <button type="submit">수정완료</button>
                    <button type="submit" onclick="history.back()">이전으로</button>
                    
            </div>
            </form>
        </body>

        </html>