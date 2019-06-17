<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register User</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new User" />
    </jsp:include>
</head>

<body>
    <div class="container">
        <h1>Register For an Account</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="Username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="Email">Email</label>
                <input id="email" name="email" class="form-control" type="email">
            </div>
            <div class="form-group">
                <label for="Password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
