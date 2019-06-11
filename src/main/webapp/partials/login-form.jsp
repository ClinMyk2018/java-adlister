<%--
  Created by IntelliJ IDEA.
  User: mykalclinard
  Date: 2019-06-11
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%--%>
<%--    if (request.getMethod().equalsIgnoreCase("post")) {--%>
<%--        String username = request.getParameter("username");--%>
<%--        String password = request.getParameter("password");--%>
<%--        if (username.equals("admin") && password.equals("password")) {--%>
<%--            response.sendRedirect("/profile.jsp");--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>


 <c:if test="${param.username.equals('admin') && param.password.equals('password')}">
    <% response.sendRedirect("/profile.jsp"); %>
 </c:if>

<form action="" method ="post" style="margin: 20% 20% 20%;">
    <div class="form-group">
        <label for="username">User Name</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Enter user name">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>


