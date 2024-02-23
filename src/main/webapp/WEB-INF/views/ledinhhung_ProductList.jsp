<%--
  Created by IntelliJ IDEA.
  User: ninhn
  Date: 2/19/2024
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<section class="container">
    <h3>Product List</h3>
    <p style="color:red " >${errorString}</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Mã sản phẩm </th>
            <th>Tên sản phẩm </th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Ảnh</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.masp}</td>
                <td>${product.tensp}</td>
                <td>${product.soluong}</td>
                <td>${product.dongia}</td>
                <td>${product.anh}</td>
                <td>
<%--                    <a href="#">Edit</a>--%>
                    <a href="ledinhhung_productEdit?masp=${product.masp}">Edit</a>
                </td>
                <td>
<%--                    <a href="#">Delete</a>--%>
                    <a href="ledinhhung_productDelete?masp=${product.masp}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="ledinhhung_productCreate"> Create Product</a>
</section>

</body>
</html>
