<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/28/2024
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body class="bg-body-tertiary">
<nav class="navbar navbar-expand-lg bg-body-secondary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Trang chủ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/books/list">Trang sách</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/borrows/list">Trang mượn sách</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <div class="shadow-sm w-75 m-auto">
        <table class="table  table-bordered table-hover text-center">
            <tr>
                <th>Số thứ tự</th>
                <th>Mã sách</th>
                <th>Tên sách</th>
                <th>Tác giả</th>
                <th>Mô tả</th>
                <th>Số lượng</th>
                <th></th>
            </tr>
            <c:forEach var="book" items="${books}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${book.code}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.description}</td>
                    <td>${book.quantity}</td>
                    <td>
                        <c:choose>
                            <c:when test="${book.quantity == 0}">
                                <button class="btn btn-sm btn-outline-primary" data-bs-toggle="modal"
                                        data-bs-target="#book-12">Mượn sách
                                </button>
                            </c:when>
                            <c:otherwise>
                                <a href="/borrows/create?book_id=${book.id}" class="btn btn-sm btn-outline-primary">Mượn
                                    sách</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="modal fade" tabindex="-1" id="book-12">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Lỗi</h4>
            </div>
            <div class="modal-body p-3">
                <p class="text-danger text-start">Cuốn sách này tạm thời đã mượn hết, vui
                    lòng mượn sách
                    khác</p>
                <div class="text-end">
                    <button type="button" class="btn btn-outline-secondary btn-sm"
                            data-bs-dismiss="modal">
                        Đóng
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>