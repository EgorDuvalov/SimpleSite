<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24.02.2021
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing In</title>
</head>
<body>
<h1>Authorization</h1>

<div>
    <label>Login:
        <input type="text" name="login"><br/>
    </label>

    <label>Password:
        <input type="password" name="pass"><br/>
    </label>
</div>
<div>
    <p>
        <button type="submit">Submit</button>
    </p>
</div>
</body>
<div>
    <button onclick="location.href='/'">Back to main</button>
    <button onclick="location.href='/signup.jsp'">Registration</button>
</div>
</html>
