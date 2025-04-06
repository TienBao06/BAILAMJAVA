package Baitap;

import java.io.*;

public class WriteReadIntegers {
    public static void main(String[] args) {
        String fileName = "numbers.dat";

        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int[] numbers = {10, 20, 30, 40, 50};
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Ghi danh sách số nguyên vào file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Các số trong file:");
            while (dis.available() > 0) {
                System.out.print(dis.readInt() + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
