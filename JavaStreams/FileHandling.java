package JavaStreams;
import java.io.*;

public class FileHandling{
    public static void main(String[] args) {
        String sourceFilePath = "input.txt";
        String destinationFilePath = "output.txt";
        
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {
            
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            System.out.println("File copied successfully from " + sourceFilePath + " to " + destinationFilePath);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file '" + sourceFilePath + "' does not exist.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred: " + e.getMessage());
        }
    }
}