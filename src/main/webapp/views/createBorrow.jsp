<%@ page import="java.sql.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/30/2024
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Trang mượn sách</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
          crossorigin="anonymous"></script>
</head>
<body class="bg-body-tertiary">
<div class="mx-auto py-5 w-25 mt-5">
  <div>
    <h2 class="text-center text-decoration-none text-secondary mb-0">TRANG MƯỢN SÁCH</h2>
  </div>
  <div class="shadow-sm bg-white p-3 mt-3 rounded">
    <form action="/borrows/create" method="post">
      <div>
        <label class="form-label" for="borrowCode">Mã mượn sách (VD: MS-0000)</label>
        <input type="text" class="form-control" id="borrowCode" name="borrowCode" pattern="^MS-\d{4}$" required>
      </div>
      <div>
        <input type="hidden" name="book_id" id="book_id" value="${book.id}">
        <label class="form-label" for="book_name">Tên sách</label>
        <input type="text" disabled class="form-control" id="book_name" name="book_name" value="${book.name}">
      </div>

      <div>
        <label for="list-student" class="form-label">Tên học sinh</label>
        <select class="form-select form-select " name="student_id" id="list-student">
          <c:forEach var="student" items="${students}">
            <option value="${student.id}">${student.name}</option>
          </c:forEach>
        </select>
      </div>
      <%Date date = new Date(System.currentTimeMillis());%>
      <div>
        <label for="borrow_day" class="form-label">Ngày mượn sách</label>
        <input type="date" disabled class="form-control" id="borrow_day" value="<%out.print(date);%>"
               name="borrow_day">
      </div>
      <div>
        <label for="return_day" class="form-label">Ngày trả sách</label>
        <input type="date" class="form-control" id="return_day" placeholder="ngày trả sách"
               min="<%out.print(date);%>" value="<%out.print(date);%>"
               name="return_day">
      </div>
      <div class="mt-3 d-flex justify-content-end ">

        <a href="/books/list" class="btn btn-secondary me-2">Hủy</a>
        <button class="btn btn-primary ">Mượn</button>
      </div>
    </form>
  </div>
</div>
</body>
</html>