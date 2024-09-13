package com.example.demo1.Service.book;

import com.example.demo1.Model.Book;

import java.util.List;

public interface IBookService {
    List<Book> selectAllBook();

    Book findBookById(int book_id);

    void updateBook(Book book);
}