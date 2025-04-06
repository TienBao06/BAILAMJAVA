package Baitap;

import java.io.*;
import java.util.concurrent.*;

public class MultiThreadKeywordSearch {
    private static final int NUM_THREADS = 4; 

    public static void main(String[] args) {
        String keyword = "Java";
        String[] files = {"input.txt", "output.txt", "number.txt"};

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        ConcurrentHashMap<String, Integer> results = new ConcurrentHashMap<>();

        for (String file : files) {
            executor.execute(() -> {
                int count = searchKeywordInFile(file, keyword);
                results.put(file, count);
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

        results.forEach((file, count) -> System.out.println(file + ": " + count + " lần xuất hiện"));
    }

    private static int searchKeywordInFile(String fileName, String keyword) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += line.split("\\b" + keyword + "\\b").length - 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
