package com.example.demo1.Service.borrow;

import com.example.demo1.Model.dto.BorrowDTO;
import com.example.demo1.Model.Borrow;
import com.example.demo1.Repository.borrow.BorrowRepo;
import com.example.demo1.Repository.borrow.IBorrowRepo;

import java.sql.SQLException;
import java.util.List;

public class BorrowService implements IBorrowService {
    IBorrowRepo borrowRepo = new BorrowRepo();

    @Override
    public List<BorrowDTO> selectAllBorrow() {
        try {
            return borrowRepo.selectAllBorrow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertBorrow(Borrow borrow) {
        try {
            borrowRepo.insertBorrow(borrow);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBorrow(int id) {
        try {
            borrowRepo.deleteBorrow(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Borrow findBorrowById(int id) {
        try {
            return borrowRepo.findBorrowById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}