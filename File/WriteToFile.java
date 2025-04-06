package Baitap;

import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            System.out.println("Nhập nội dung (nhập 'exit' để dừng):");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Dữ liệu đã được ghi vào file output.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
