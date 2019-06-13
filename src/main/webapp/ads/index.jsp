<%--
  Created by IntelliJ IDEA.
  User: mykalclinard
  Date: 2019-06-12
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ads Page</title>
    <%@include file="/partials/head.jsp"%>
</head>
<body>
    <%@include file="/partials/navbar.jsp"%>

    <div class="container">

        <c:forEach items="${ads}" var="ad">
            <h2>${ad.title}</h2>
            <h4>${ad.description}</h4>
            <p>Product ID: ${ad.id}</p>
            <p>User ID: $${ad.userId}</p>
        </c:forEach>

    </div>

</body>
</html>
