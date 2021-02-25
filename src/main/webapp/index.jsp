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
    <%
        //TODO session is open
    %>
</div>

<div>       <!-- content -->
    <div>    <!-- buttons holder -->
        <button onclick="location.href='/signin'">Sign In</button>
        <button onclick="location.href='/signup'">Sign Up</button>
    </div>
</div>
</body>
</html>