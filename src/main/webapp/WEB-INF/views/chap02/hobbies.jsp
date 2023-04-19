<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h1>[${n}]님 취미 목록</h1>
    <ol>
        <!-- ${hList} -> toString으로 나오기 때문에 반복문으로 -->
        <c:forEach var="h" items="${hList}">
            <li>${h}</li>
        </c:forEach>
    </ol>
</body>

</html>