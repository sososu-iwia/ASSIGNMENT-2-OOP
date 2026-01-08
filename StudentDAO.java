package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DatabaseConnector;
import model.Student;

public class StudentDAO {
    public void save(Student s) throws Exception {
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";

        try (
                Connection c = DatabaseConnector.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getMajor());
            ps.setDouble(5, s.getGpa());
            ps.executeUpdate();
        }

    }

    public List<Student> findAll() throws Exception {
        List<Student> list = new ArrayList();
        String sql = "SELECT * FROM students";

        try (
                Connection c = DatabaseConnector.getConnection();
                ResultSet rs = c.createStatement().executeQuery(sql);
        ) {
            while(rs.next()) {
                list.add(new Student(rs.getString("id"), rs.getString("name"), rs.getInt("age"), rs.getString("major")));
            }
        }

        return list;
    }
}
