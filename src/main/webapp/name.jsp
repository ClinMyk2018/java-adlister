<%--
  Created by IntelliJ IDEA.
  User: mykalclinard
  Date: 2019-06-11
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Name Page</title>
    <%@ include file="partials/headlinks.jsp" %>

</head>
<body>

<%@ include file="partials/navbar.jsp" %>


<form action="" method ="post" style="margin: 10% 20% 20%;">
    <div class="form-group">
        <label for="username">Name</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Enter your name">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<c:if test="${param.username == null}">
    <% response.sendRedirect("/name.jsp"); %>
</c:if>
<c:if test="${param.username != null}">
    <% response.sendRedirect("/howdy.jsp"); %>
</c:if>

<%@include file="partials/scriptlinks.jsp"%>

</body>
</html>
