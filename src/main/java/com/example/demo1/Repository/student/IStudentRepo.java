package com.example.demo1.Repository.student;

import com.example.demo1.Model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepo {
    List<Student> selectAllStudent() throws SQLException;
}