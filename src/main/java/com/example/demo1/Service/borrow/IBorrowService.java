package com.example.demo1.Service.borrow;

import com.example.demo1.Model.dto.BorrowDTO;
import com.example.demo1.Model.Borrow;

import java.util.List;

public interface IBorrowService {
    List<BorrowDTO> selectAllBorrow();

    void insertBorrow(Borrow borrow);

    void deleteBorrow(int id);

    Borrow findBorrowById(int id);
}