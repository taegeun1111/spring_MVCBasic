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
            <form action="/score/change?stuNum=${stuNum}" method="get">
                <div id="wrap">
                    <h1>${s.name}님의 성적 정보</h1>
                    <input type="hidden" name="stuNum" value="${stuNum}">
                    <ul>
                        <li name="kor" value="${kor}"># 국어: ${s.kor}</li>
                        <li name="eng" value="${eng}"># 영어: ${s.eng}</li>
                        <li># 수학: ${s.math}</li>
                        <li># 총점: ${s.total}</li>
                        <li># 평균: ${s.average}</li>
                        <li># 학점: ${s.grade}</li>
                    </ul>
                    <a href="/score/list">목록</a>
                    <button type="submit">수정하기</button>
                </div>
            </form>
        </body>

        </html>