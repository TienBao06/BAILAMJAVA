package Baitap;
import java.io.*;
import java.util.Scanner;

public class KeywordSearch {
    private static final String MERGED_FILE = "input.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập từ khóa cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();

        int count = searchKeyword(keyword);
        System.out.println("Từ khóa \"" + keyword + "\" xuất hiện " + count + " lần trong file.");
    }

    private static int searchKeyword(String keyword) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(MERGED_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countOccurrences(line.toLowerCase(), keyword);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return count;
    }

    private static int countOccurrences(String text, String keyword) {
        int count = 0, index = 0;
        while ((index = text.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }
}
