<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,com.demo.beans.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Collection</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #fafafa;
        margin: 20px;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background: #fff;
    }
    th, td {
        border: 1px solid #ccc;
        padding: 8px 12px;
        text-align: center;
    }
    th {
        background-color: #f0f0f0;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
</style>
</head>
<body>
    <h2>Available Stock</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Car Name</th>
            <th>Price</th>
            <th>Stock</th>
        </tr>

        <%
        List<Product> list = (List<Product>) request.getAttribute("productList");
        for (Product p : list) {
        %>
        <tr>
            <td><%=p.getProductId()%></td>
            <td><%=p.getName()%></td>
            <td><%=p.getPrice()%></td>
            <td><%=p.getQty()%></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
