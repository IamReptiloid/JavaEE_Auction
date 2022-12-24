<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auctions page</title>
    <link rel="stylesheet" href="../../css/user/createdAuction.css">
    <%@include file="../../templates/styles.jsp" %>
</head>
<body>
    <%@include file="./element/header.jsp" %>
    <div class="content">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Closed</th>
                <th></th>
            </tr>
            </thead>
            <tbody class="tbody">
            <c:forEach var="i" items="${auctionList}">
                <tr class="auction" data-id="${i.getId()}">
                    <td>
                        <textarea class="input">${i.getName()}</textarea>
                    </td>
                    <td>
                        <textarea class="input">${i.getDescription()}</textarea>
                    </td>
                    <td>
                        <c:if test = "${i.status eq 'close'}">
                            <input type="checkbox" checked class="checkbox">
                        </c:if>
                        <c:if test = "${i.status eq 'open'}">
                            <input type="checkbox" class="checkbox">
                        </c:if>
                    </td>
                    <td class="goTo"><button data-id="${i.getId()}">перейти</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="buttons">
            <button class="add button">Добавить</button>
            <button class="send button">Отправить изменения</button>
        </div>
    </div>
    <script src="../../js/createdAuctions.js"></script>
</body>
</html>
