package com.example.demo1.Repository.borrow;

import com.example.demo1.Model.dto.BorrowDTO;
import com.example.demo1.Model.Borrow;
import com.example.demo1.connectDB.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepo implements IBorrowRepo {

    private static ResultSet getResultSet() throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "select br.id, br.code,b.id as book_id,b.name as book_name ,b.author as book_author,s.name as student_name,s.classroom,br.borrow_day,br.return_day\n" +
                "from borrows br\n" +
                "join books b\n" +
                "on b.id = br.book_id\n" +
                "join students s\n" +
                "on s.id = br.student_id\n" +
                "where status = true;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    @Override
    public List<BorrowDTO> selectAllBorrow() throws SQLException {
        List<BorrowDTO> borrows = new ArrayList<>();
        ResultSet rs = getResultSet();
        while (rs.next()) {
            BorrowDTO borrow = new BorrowDTO();
            borrow.setId(rs.getInt("id"));
            borrow.setCode(rs.getString("code"));
            borrow.setBorrowDay(rs.getDate("borrow_day"));
            borrow.setReturnDay(rs.getDate("return_day"));
//            Book book = new Book();
//            book.setId(rs.getInt("book_id"));
            borrow.setBookName(rs.getString("book_name"));
            borrow.setBookAuthor(rs.getString("book_author"));
//            Student student = new Student();
            borrow.setStudentName(rs.getString("student_name"));
            borrow.setStudentClass(rs.getString("classroom"));
            borrows.add(borrow);
        }
        return borrows;
    }


    @Override
    public void insertBorrow(Borrow borrow) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "insert into borrows(code,book_id,student_id,status,borrow_day,return_day) value(?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, borrow.getCode());
        ps.setInt(2, borrow.getBook_id());
        ps.setInt(3, borrow.getStudent_id());
        ps.setBoolean(4, borrow.isStatus());
        ps.setDate(5, borrow.getBorrow_day());
        ps.setDate(6, borrow.getReturn_day());
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public void deleteBorrow(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "delete from borrows where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Borrow findBorrowById(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from borrows where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Borrow borrow = new Borrow();
            borrow.setId(rs.getInt("id"));
            borrow.setCode(rs.getString("code"));
            borrow.setBook_id(rs.getInt("book_id"));
            borrow.setStudent_id(rs.getInt("student_id"));
            borrow.setStatus(rs.getBoolean("status"));
            borrow.setBorrow_day(rs.getDate("borrow_day"));
            borrow.setReturn_day(rs.getDate("return_day"));
            return borrow;
        }
        return null;
    }
}