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
                <h1>${name}님의 성적 정보</h1>
                <ul>
                    <li># 국어: ${kor}</li>
                    <li># 영어: ${eng}</li>
                    <li># 수학: ${math}</li>
                    <li># 총점: ${total}</li>
                    <li># 평균: ${average}</li>
                    <li># 학점: ${grade}</li>
                </ul>
                <a href="/score/list">목록</a>
            </div>
        </body>

        </html>