package com.example.demo1.Repository.borrow;

import com.example.demo1.Model.dto.BorrowDTO;
import com.example.demo1.Model.Borrow;

import java.sql.SQLException;
import java.util.List;

public interface IBorrowRepo {
    List<BorrowDTO> selectAllBorrow() throws SQLException;
    void insertBorrow(Borrow borrow) throws SQLException;

    void deleteBorrow(int id)throws SQLException;

    Borrow findBorrowById(int id) throws SQLException;
}