<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ads View</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 style="color: dodgerblue;">Here are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6" style="color: lightslategray; border: 2px solid dodgerblue; border-radius: 5px; margin: 2rem;">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <input type="submit" name="editAd" value="Edit" />
            <input type="submit" name="deleteAd" value="Delete" />
        </div>
    </c:forEach>
</div>

</body>
</html>
