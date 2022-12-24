<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="userHeader">
    <div class="headerUser__name">Auction</div>
    <div class="bottom_auction">
        <a class="bottom" href="/auction?command=auction">Все аукционы</a>
        <a class="bottom" href="/auction?command=createdAuction">Мои аукционы</a>
    </div>
    <div>
        <a class="bottom" href="/auction?command=profile">Профиль</a>
        <a class="bottom" href="/auction?command=">Выход</a>
    </div>

</header>