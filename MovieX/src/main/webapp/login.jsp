<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Moviex: Login</title>
    <link rel="stylesheet" href="stylesheet/login.css"/>
    <link rel="icon" href="assets/popcorn.png">
</head>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<script>
    alert("<%=errorMessage%>");
</script>
<%
    }
%>

<body>

<div class="background"></div>
<div class="container">
    <div class="content">
        <h1>Login</h1>
        <form action="login" method="post">
            <div class="form-group">
                <label for="username">Username:</label> <input type="text"
                                                               name="username" id="username" placeholder="username"
                                                               required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label> <input type="password"
                                                               name="password" id="password" placeholder="password"
                                                               required>
            </div>
            <input type="submit" value="Login">
        </form>
        <p>
            Don't have an account? <a href="registration.jsp">Signup</a>
        </p>
    </div>
</div>

</body>
</html>
