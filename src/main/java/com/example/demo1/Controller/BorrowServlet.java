package com.example.demo1.Controller;

import com.example.demo1.Model.Book;
import com.example.demo1.Model.Borrow;
import com.example.demo1.Model.Student;
import com.example.demo1.Service.book.BookService;
import com.example.demo1.Service.book.IBookService;
import com.example.demo1.Service.borrow.BorrowService;
import com.example.demo1.Service.borrow.IBorrowService;
import com.example.demo1.Service.student.IStudentService;
import com.example.demo1.Service.student.StudentService;
import com.example.demo1.Model.dto.BorrowDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "BorrowServlet",urlPatterns = "/borrows/*")
public class BorrowServlet extends HttpServlet {
    IBookService bookService = new BookService();
    IStudentService studentService = new StudentService();
    IBorrowService borrowService = new BorrowService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListBorrow(req,resp);
                break;
            case "/create":
                showFormCreateBorrow(req,resp);
                break;
            case "/delete":
                deleteBorrow(req,resp);
                break;

        }
    }

    private void showFormCreateBorrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int book_id = Integer.parseInt(req.getParameter("book_id"));
        Book book = bookService.findBookById(book_id);
        req.setAttribute("book", book);
        getAllAuthors(req, resp);
        req.getRequestDispatcher("/views/createBorrow.jsp").forward(req, resp);
    }

    private void deleteBorrow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Borrow borrow = borrowService.findBorrowById(id);
        Book book = bookService.findBookById(borrow.getBook_id());
        int quantity = book.getQuantity();
        book.setQuantity(quantity + 1);
        bookService.updateBook(book);
        borrowService.deleteBorrow(id);
        resp.sendRedirect("/borrows/list");
    }

    private void showListBorrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BorrowDTO> borrows  = borrowService.selectAllBorrow();
        req.setAttribute("borrows",borrows);
        req.getRequestDispatcher("/views/borrowList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                insertBorrow(req,resp);
                break;
        }
    }

    private void insertBorrow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("borrowCode");
        int book_id = Integer.parseInt(req.getParameter("book_id"));
        int student_id = Integer.parseInt(req.getParameter("student_id"));
        Date borrow_day = new Date(System.currentTimeMillis());
        Date return_day = Date.valueOf(req.getParameter("return_day"));
        Borrow borrow = new Borrow();
        borrow.setCode(code);

        borrow.setBook_id(book_id);
        Book book = bookService.findBookById(book_id);
        int quantity = book.getQuantity();
        book.setQuantity(quantity - 1);
        bookService.updateBook(book);

        req.setAttribute("book",book);
        borrow.setStudent_id(student_id);
        borrow.setStatus(true);
        borrow.setBorrow_day(borrow_day);
        borrow.setReturn_day(return_day);
        borrowService.insertBorrow(borrow);
        resp.sendRedirect("/books/list");
    }

    private void getAllAuthors(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> students = studentService.selectAllStudent();
        req.setAttribute("students", students);
    }
}