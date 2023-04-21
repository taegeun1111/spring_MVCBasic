<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <link rel="stylesheet" href="/assets/css/detail.css">
        </head>

        <body>
            <section id="detail-section">
                <div class="detail-title">
                    <h1>제목 : ${one.title}</h1>
                    <div>내용 : ${one.content}</div>
                </div>
                <div class="detail-sub">
                    <a href="/board/list">이전으로</a>
                </div>
            </section>
        </body>

        </html>