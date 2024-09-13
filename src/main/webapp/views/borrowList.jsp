<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/30/2024
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang sách đã mượn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

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
    <table class="table table-bordered table-hover text-center">
        <tr>
            <th>Số thứ tự</th>
            <th>Mã mượn sách</th>
            <th>Tên sách</th>
            <th>Tác giả</th>
            <th>Tên học sinh</th>
            <th>Lớp</th>
            <th>Ngày mượn</th>
            <th>Ngày Trả</th>
            <th></th>
        </tr>
        <c:forEach var="borrow" items="${borrows}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${borrow.code}</td>
                <td>${borrow.bookName}</td>
                <td>${borrow.bookAuthor}</td>
                <td>${borrow.studentName}</td>
                <td>${borrow.studentClass}</td>
                <td>${borrow.borrowDay}</td>

                <td>${borrow.returnDay}</td>
                <td>
                    <div class="me-2">
                        <a href="/borrows/delete?id=${borrow.id}" data-student="${borrow.studentName}" data-book="${borrow.bookName}" class="btn btn-sm btn-outline-danger tra-sach"
                           data-bs-toggle="modal"
                           data-bs-target="#borrow">Trả sách</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="modal fade" tabindex="-1" id="borrow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title fw-bold">TRẢ SÁCH</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body p-3 text-start">
                <p>
                    Học sinh
                    <span class="fw-bold" id="student_name"></span>
                    thực hiện trả sách
                    <span class="fw-bold" id="book_name"></span>.
                </p>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-secondary btn-sm"
                            data-bs-dismiss="modal">
                        Không
                    </button>
                    <a href="/borrows/delete?id=${borrow.id}" id="delete"
                       class="btn btn-outline-danger btn-sm">Trả sách</a></div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<script>
    let trasachBtns = document.querySelectorAll(".tra-sach");
    trasachBtns.forEach(el => {
        el.addEventListener("click", () => {
            let studentName = el.dataset.student;
            let bookName = el.dataset.book;
            let url = el.getAttribute("href");
            document.getElementById("student_name").innerText = studentName;
            document.getElementById("book_name").innerText = bookName;
            document.getElementById("delete").setAttribute("href",url);
        })
    })
</script>
</body>
</html>