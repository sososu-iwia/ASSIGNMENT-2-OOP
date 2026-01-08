package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DatabaseConnector;
import model.Teacher;

public class TeacherDAO {
    public void save(Teacher t) throws Exception {
        String sql = "INSERT INTO teachers VALUES (?, ?, ?, ?, ?)";

        try (
                Connection c = DatabaseConnector.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, t.getId());
            ps.setString(2, t.getName());
            ps.setInt(3, t.getAge());
            ps.setString(4, t.getDepartment());
            ps.setDouble(5, t.getSalary());
            ps.executeUpdate();
        }

    }

    public List<Teacher> findAll() throws Exception {
        List<Teacher> list = new ArrayList();
        String sql = "SELECT * FROM teachers";

        try (
                Connection c = DatabaseConnector.getConnection();
                ResultSet rs = c.createStatement().executeQuery(sql);
        ) {
            while(rs.next()) {
                list.add(new Teacher(rs.getString("id"), rs.getString("name"), rs.getInt("age"), rs.getString("department"), rs.getDouble("salary")));
            }
        }

        return list;
    }

    public void deleteById(String id) throws Exception {
        String sql = "DELETE FROM teachers WHERE id = ?";

        try (
                Connection c = DatabaseConnector.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, id);
            ps.executeUpdate();
        }

    }
}
