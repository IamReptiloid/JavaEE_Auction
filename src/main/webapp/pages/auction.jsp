<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Auctions page</title>
</head>
<body>
<p>Auctions</p>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Status</th>
        </tr>
        <c:forEach var="i" items="${auctionList}">
            <tr>
                <td>${i.getId()}</td>
                <td>${i.getName()}</td>
                <td>${i.getDescription()}</td>
                <td>${i.getStatus()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
