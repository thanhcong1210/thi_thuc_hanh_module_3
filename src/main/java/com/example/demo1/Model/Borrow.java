package com.example.demo1.Model;

import java.sql.Date;

public class Borrow {
    private int id;
    private String code;
    private int book_id;
    private int student_id;
    private boolean status = false;
    private Date borrow_day;
    private Date return_day;
    private Book book;
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBorrow_day() {
        return borrow_day;
    }

    public void setBorrow_day(Date borrow_day) {
        this.borrow_day = borrow_day;
    }

    public Date getReturn_day() {
        return return_day;
    }

    public void setReturn_day(Date return_day) {
        this.return_day = return_day;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}