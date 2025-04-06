package Baitap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;

public class MergeAndCleanFiles {
    private static final String INPUT_DIR = "downloads";
    private static final String MERGED_FILE = "merged_output.txt";

    public static void main(String[] args) {
        File outputFile = new File(MERGED_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            File[] files = new File(INPUT_DIR).listFiles();
            if (files != null) {
                for (File file : files) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                        }

                       
                        String cleanedContent = isHtml(content.toString()) ? cleanHtml(content.toString()) : content.toString();
                        writer.write(cleanedContent);
                        writer.newLine();
                    }
                }
            }
            System.out.println("Merged content into " + MERGED_FILE);
        } catch (IOException e) {
            System.err.println("Error merging files: " + e.getMessage());
        }
    }

    private static boolean isHtml(String content) {
        return content.trim().startsWith("<!DOCTYPE") || content.contains("<html");
    }

    private static String cleanHtml(String htmlContent) {
        Document doc = Jsoup.parse(htmlContent);
        return doc.text();
    }
}
