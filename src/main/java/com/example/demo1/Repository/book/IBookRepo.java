package com.example.demo1.Repository.book;

import com.example.demo1.Model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookRepo {
    List<Book> selectAllBook() throws SQLException;

    Book findBookById(int book_id) throws SQLException;

    void updateBook(Book book) throws SQLException;
}