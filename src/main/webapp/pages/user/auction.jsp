<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auctions page</title>
    <link rel="stylesheet" href="../../css/user/auctions.css">
    <%@include file="../../templates/styles.jsp" %>
</head>
<body>
    <%@include file="./element/header.jsp" %>
    <div class="content">
        <table class="table" id="AuctionTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody class="tbody">
                <c:forEach var="i" items="${auctionList}">
                <tr class="auction" data-status="${i.getStatus()}" >
                    <td data-id="${i.getId()}">${i.getId()}</td>
                    <td data-id="${i.getId()}">${i.getName()}</td>
                    <td data-id="${i.getId()}">${i.getDescription()}</td>
                    <td data-id="${i.getId()}">${i.getStatus()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="../../js/auction.js"></script>
</body>
</html>
