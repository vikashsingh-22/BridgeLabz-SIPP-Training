package JavaStreams;

import java.io.*;

public class BuffferedHandling {
    private static final int BUFFER_SIZE = 4096; 
    
    public static void main(String[] args) {
        String sourceFilePath = "largeFile.dat";
        String destFileBuffered = "output_buffered.dat";
        String destFileUnbuffered = "output_unbuffered.dat";
        
        long bufferedTime = copyWithBufferedStreams(sourceFilePath, destFileBuffered);
        long unbufferedTime = copyWithUnbufferedStreams(sourceFilePath, destFileUnbuffered);
        
        System.out.println("Buffered Stream Copy Time: " + bufferedTime / 1_000_000.0 + " ms");
        System.out.println("Unbuffered Stream Copy Time: " + unbufferedTime / 1_000_000.0 + " ms");
        System.out.println("Performance Improvement: " + 
            ((unbufferedTime - bufferedTime) * 100.0 / unbufferedTime) + "% faster with buffered streams");
    }
    
    private static long copyWithBufferedStreams(String sourcePath, String destPath) {
        long startTime = System.nanoTime();
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath), BUFFER_SIZE);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath), BUFFER_SIZE)) {
            
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file '" + sourcePath + "' does not exist.");
            return 0;
        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
            return 0;
        }
        
        return System.nanoTime() - startTime;
    }
    
    private static long copyWithUnbufferedStreams(String sourcePath, String destPath) {
        long startTime = System.nanoTime();
        
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {
            
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file '" + sourcePath + "' does not exist.");
            return 0;
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
            return 0;
        }
        
        return System.nanoTime() - startTime;
    }
}