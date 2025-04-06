package universityms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/qlydiemsinhvien";
    private static final String USER = "root";
    private static final String PASSWORD = "2904"; 

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("❌ Lỗi kết nối MySQL: " + e.getMessage());
            return null;
        }
    }
}
