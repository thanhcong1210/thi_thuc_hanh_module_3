package com.example.demo1.Repository.student;

import com.example.demo1.Model.Student;
import com.example.demo1.connectDB.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo {
    @Override
    public List<Student> selectAllStudent() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from students";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setCode(rs.getString("code"));
            student.setName(rs.getString("name"));
            student.setClassroom(rs.getString("classroom"));
            students.add(student);
        }
        return students;
    }
}