package Baitap;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadFileReader {
    private static final int PART_SIZE = 1024 * 1024; // 1MB mỗi phần

    public static void main(String[] args) {
        String fileName = "largefile.txt";
        String outputFile = "output.txt";
        File file = new File(fileName);
        long fileSize = file.length();
        int numParts = (int) Math.ceil((double) fileSize / PART_SIZE);

        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 luồng
        byte[][] fileParts = new byte[numParts][];

        for (int i = 0; i < numParts; i++) {
            final int partIndex = i;
            executor.execute(() -> {
                try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
                    long start = partIndex * PART_SIZE;
                    int size = (int) Math.min(PART_SIZE, fileSize - start);
                    byte[] buffer = new byte[size];

                    raf.seek(start);
                    raf.readFully(buffer);
                    fileParts[partIndex] = buffer;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

     
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            for (byte[] part : fileParts) {
                fos.write(part);
            }
            System.out.println("File đã được đọc và ghép lại thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
