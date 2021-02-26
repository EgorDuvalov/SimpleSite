<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 26.02.2021
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing Out</title>
</head>
<body>
<h1>
    <%
        if (session.getAttribute("current_user") == null) {
            out.println("You haven't been authorised");
        } else {
            out.println("You've been signed out");
            session.setAttribute("current_user", null);
        }
    %>
</h1>
</body>
<div>
    <button onclick="location.href='/'"> Back to main</button>
</div>
</html>
