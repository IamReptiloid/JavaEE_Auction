<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auctions page</title>
    <link rel="stylesheet" href="../../css/user/lots.css">
    <%@include file="../../templates/styles.jsp" %>
</head>
<body>
<%@include file="./element/header.jsp" %>
<div class="content">
    <div class="lots">
        <c:forEach var="i" items="${lotList}">
        <div class="lot" data-status="${i.status}" >
            <img class="img" src="${i.pathToPicture}" alt="picture">
            <div data-id="${i.id}">${i.name}</div>
            <div data-id="${i.id}"> ${i.price}</div>
            <div data-id="${i.id}">${i.status}</div>
        </div>
        </c:forEach>
    </div>
</div>

</body>
</html>