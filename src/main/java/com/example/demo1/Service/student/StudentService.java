package com.example.demo1.Service.student;

import com.example.demo1.Model.Student;
import com.example.demo1.Repository.student.IStudentRepo;
import com.example.demo1.Repository.student.StudentRepo;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService{
    IStudentRepo studentRepo = new StudentRepo();
    @Override
    public List<Student> selectAllStudent() {
        try {
            return studentRepo.selectAllStudent();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}