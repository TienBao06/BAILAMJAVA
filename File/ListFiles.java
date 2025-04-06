package Baitap;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String dirPath = "C:\\Users\\Admin\\Documents\\C++"; 

        File directory = new File(dirPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            System.out.println("Danh sách các file trong thư mục:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Đường dẫn không phải là thư mục!");
        }
    }
}
