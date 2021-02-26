<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Simple Site</title>
</head>
<body>
<!-- header -->
<div>
    <h1>Welcome</h1>
    <h2>
        <%
            Object current_user = session.getAttribute("current_user");
            if (current_user != null) {
                out.println("Nice to see you again " + current_user + "!");
            }
        %>
    </h2>
</div>

<div>       <!-- content -->
    <div>    <!-- buttons holder -->
        <button onclick="location.href='/signin'">Sign In</button>
        <button onclick="location.href='/signout'">Sign Out</button>
        <button onclick="location.href='/signup'">Sign Up</button>
    </div>
</div>
</body>
</html>