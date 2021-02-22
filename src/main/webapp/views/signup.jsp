<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
<h2> Registration </h2>
<form method="post">
    <div>
        <label>Login:
            <input type="text" name="login"><br/>
        </label>

        <label>Password:
            <input type="password" name="pass"><br/>
        </label>

        <label>Email:
            <input type="email" name="email"><br/>
        </label>

        <p>
            <input type="radio" id="admin" name="role" value="1">
            <label for="admin">Admin </label><br>
            <input type="radio" id="client" name="role" value="0">
            <label for="client">Client </label><br>
        </p>
    </div>

    <div>
        <p>
            <button type="submit">Submit</button>
        </p>
    </div>
</form>
<div>
    <%
        if (request.getAttribute("Feedback") == null) {
            out.println("");
        }
        else {
            out.println(request.getAttribute("Feedback"));
        }
    %>
</div>
</body>
<div>
    <button onclick="location.href='/'"> Back to main</button>
</div>
</html>