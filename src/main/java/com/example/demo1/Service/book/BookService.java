package com.example.demo1.Service.book;

import com.example.demo1.Model.Book;
import com.example.demo1.Repository.book.BookRepo;
import com.example.demo1.Repository.book.IBookRepo;

import java.sql.SQLException;
import java.util.List;

public class BookService implements IBookService{
    IBookRepo bookRepo = new BookRepo();
    @Override
    public List<Book> selectAllBook() {
        try {
            return bookRepo.selectAllBook();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findBookById(int book_id) {
        try {
            return bookRepo.findBookById(book_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBook(Book book) {
        try {
            bookRepo.updateBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}