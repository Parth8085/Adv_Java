<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f2f2f2;
    }

    .container {
        width: 300px;
        margin: 80px auto;
        padding: 15px;
        background: #ffffff;
        border: 1px solid #ccc;
    }

    label {
        display: block;
        margin-top: 10px;
    }

    input {
        width: 95%;
        padding: 6px;
        margin-top: 5px;
    }

    button {
        margin-top: 15px;
        padding: 8px 12px;
        cursor: pointer;
    }

    .error {
        color: red;
        text-align: center;
        font-weight: bold;
    }

    .success {
        color: green;
        text-align: center;
        font-weight: bold;
    }

</style>

</head>
<body>

<div class="container">

<%
String msg = (String) request.getAttribute("msg");

if ("invalid".equals(msg)) {
%>
    <p class="error">User is Invalid</p>
<%
}

if ("valid".equals(msg)) {
%>
    <p class="success">User is Valid</p>
<%
}
%>

<form action="LoginServlet" method="post">
    <label>Email</label>
    <input type="text" name="email">

    <label>Password</label>
    <input type="password" name="password">

    <button type="submit">Login</button>
</form>

</div>

</body>
</html>