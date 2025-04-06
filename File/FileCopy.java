package Baitap;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	public class FileCopy {
	    public static void main(String[] args) {
	        String inputFile = "input.txt";  
	        String outputFile = "output.txt"; 

	        try (FileInputStream fis = new FileInputStream(inputFile);
	             FileOutputStream fos = new FileOutputStream(outputFile)) {

	            int byteData;
	            while ((byteData = fis.read()) != -1) { 
	                fos.write(byteData); 
	            }

	            System.out.println("Sao chép file thành công!");

	        } catch (IOException e) {
	            System.err.println("Lỗi: " + e.getMessage());
	        }
	    }
	}


