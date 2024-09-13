package com.example.demo1.Repository.book;

import com.example.demo1.Model.Book;
import com.example.demo1.connectDB.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo {
    @Override
    public List<Book> selectAllBook() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from books";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setCode(rs.getString("code"));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setDescription(rs.getString("description"));
            book.setQuantity(rs.getInt("quantity"));
            books.add(book);
        }
        return books;
    }

    @Override
    public Book findBookById(int book_id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from books where id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, book_id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setCode(rs.getString("code"));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setDescription(rs.getString("description"));
            book.setQuantity(rs.getInt("quantity"));
            return book;
        }
        return null;
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "update books set quantity = ? where id =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,book.getQuantity());
        ps.setInt(2,book.getId());
        ps.executeUpdate();
    }
}