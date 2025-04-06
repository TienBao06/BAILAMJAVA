package universityms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int StudentID;
    private String name;
    private int age;
    private String email;
    private double gpa;

    public Student(int studentID, String name, int age, String email, double gpa) {
        this.StudentID = studentID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gpa = gpa;
    }

    public int getStudentID() {
        return StudentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public double getGpa() {
        return gpa;
    }

    public static String generateEmail(String name) {
        String formatted = name.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        return formatted + "@vku.udn.vn";
    }

    public static void addStudent(String name, int age, double gpa) throws SQLException {
        String email = generateEmail(name);
        if (isEmailExists(email)) {
            System.out.println("⚠️ Email đã tồn tại! Không thể thêm sinh viên.");
            return;
        }

        String query = "INSERT INTO student (name, age, email, gpa) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, email);
            ps.setDouble(4, gpa);
            ps.executeUpdate();
            System.out.println("✅ Sinh viên đã được thêm thành công! Email: " + email);
        }
    }

    private static boolean isEmailExists(String email) throws SQLException {
        String query = "SELECT * FROM student WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public static List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("StudentID"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getDouble("gpa")
                ));
            }
        }
        return students;
    }

    public static void updateStudent(int studentID, String name, int age, double gpa) throws SQLException {
        String query = "UPDATE Student SET name = ?, age = ?, gpa = ? WHERE StudentID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, gpa);
            ps.setInt(4, studentID);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Cập nhật sinh viên thành công!");
            } else {
                System.out.println("⚠️ Không tìm thấy sinh viên để cập nhật.");
            }
        }
    }

    public static void deleteStudent(int studentID) throws SQLException {
        String query = "DELETE FROM student WHERE StudentID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, studentID);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Xoá sinh viên thành công!");
            } else {
                System.out.println("⚠️ Không tìm thấy sinh viên để xoá.");
            }
        }
    }

    public String toString() {
        return String.format("ID: %d | Tên: %s | Tuổi: %d | Email: %s | GPA: %.2f",
                StudentID, name, age, email, gpa);
    }
}
