package universityms;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static boolean isLoggedIn = false;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> login();
                case 2 -> logout();
                case 3 -> addStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> showStudents();
                case 0 -> System.out.println("👋 Tạm biệt!");
                default -> System.out.println("⚠️ Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n===== QUẢN LÝ SINH VIÊN VKU =====");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng xuất");
        System.out.println("3. Thêm sinh viên");
        System.out.println("4. Cập nhật sinh viên");
        System.out.println("5. Xoá sinh viên");
        System.out.println("6. Xem danh sách sinh viên");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
    }

    private static void login() {
        if (isLoggedIn) {
            System.out.println("🔓 Bạn đã đăng nhập rồi.");
        } else {
            System.out.print("Nhập email để đăng nhập: ");
            String email = scanner.nextLine();
            // Ở đây có thể kiểm tra email nếu muốn
            isLoggedIn = true;
            System.out.println("✅ Đăng nhập thành công!");
        }
    }

    private static void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            System.out.println("🔒 Đã đăng xuất.");
        } else {
            System.out.println("⚠️ Bạn chưa đăng nhập.");
        }
    }

    private static void addStudent() {
        if (!isLoggedIn) {
            System.out.println("⚠️ Vui lòng đăng nhập trước khi thêm sinh viên.");
            return;
        }

        try {
            System.out.print("Tên sinh viên: ");
            String name = scanner.nextLine();

            System.out.print("Tuổi: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            Student.addStudent(name, age, gpa);
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi thêm sinh viên: " + e.getMessage());
        }
    }

    private static void updateStudent() {
        if (!isLoggedIn) {
            System.out.println("⚠️ Vui lòng đăng nhập trước khi cập nhật.");
            return;
        }

        try {
            System.out.print("Nhập ID sinh viên cần sửa: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Tên mới: ");
            String name = scanner.nextLine();

            System.out.print("Tuổi mới: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("GPA mới: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            Student.updateStudent(id, name, age, gpa);
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi cập nhật: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        if (!isLoggedIn) {
            System.out.println("⚠️ Vui lòng đăng nhập trước khi xoá.");
            return;
        }

        try {
            System.out.print("Nhập ID sinh viên cần xoá: ");
            int id = Integer.parseInt(scanner.nextLine());

            Student.deleteStudent(id);
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi xoá: " + e.getMessage());
        }
    }

    private static void showStudents() {
        try {
            List<Student> students = Student.getAllStudents();
            if (students.isEmpty()) {
                System.out.println("📭 Không có sinh viên nào trong hệ thống.");
            } else {
                System.out.println("\n📋 DANH SÁCH SINH VIÊN:");
                for (Student s : students) {
                    System.out.println(s);
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi hiển thị sinh viên: " + e.getMessage());
        }
    }
}
