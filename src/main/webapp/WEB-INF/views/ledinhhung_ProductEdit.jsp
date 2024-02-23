<%--
  Created by IntelliJ IDEA.
  User: ninhn
  Date: 2/19/2024
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<section class="container">
    <h3>Create Product</h3>
    <p style="color:red " >${errorString}</p>
    <form method="post" action="${pageContext.request.contextPath}/ledinhhung_productEdit">
        <table>
            <tr>
                <td>Mã sản phẩm </td>
                <td><input type="text" name="masp" value="${product.masp}" readonly/></td>
            </tr>
            <tr>
                <td>Tên sản phẩm </td>
                <td><input type="text" name="tensp" value="${product.tensp}"/></td>
            </tr>
            <tr>
                <td>Số lượng </td>
                <td><input type="text" name="soluong" value="${product.soluong}"/></td>
            </tr>
            <tr>
                <td>Đơn giá </td>
                <td><input type="text" name="dongia" value="${product.dongia}"/></td>
            </tr>
            <tr>
                <td>Ảnh</td>
                <td><input type="text" name="anh" value="${product.anh}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Ghi lại " class="btn btn-success"/>
                    <a href="ledinhhung_productList">Quay Lại</a>
                </td>
            </tr>
        </table>
    </form>
</section>

</body>
</html>
