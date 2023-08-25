import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead {
public static void main(String[] args) {
	
	 String file1 = "E:\\JAVA\\Problem2\\src\\input.csv";
     String file2 = "output.csv";

     readcsv(file1,file2);

     System.out.println("Task Has beed Completed Successfully....");
 }

 public static void readcsv(String inputFile, String outputFile) {
     try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
          BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

         String line;
         boolean isLine = true;

         while ((line = reader.readLine()) != null) {
             String[] data = line.split(",");
             int sum = sumofvalues(data);
             String newLine = line + "," + sum;

             if (isLine) {
                 isLine = false;
             } else {
                 writer.newLine();
             }

             writer.write(newLine);
         }

     } catch (IOException e) {
         e.printStackTrace();
     }
 }

 public static int sumofvalues(String[] data) {
     int sum = 0;
     for (String value : data) {
         sum += Integer.parseInt(value);
     }
     return sum;
 }
}
