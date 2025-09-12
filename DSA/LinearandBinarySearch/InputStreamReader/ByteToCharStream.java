package LinearandBinarySearch.InputStreamReader;

import java.io.*;

public class ByteToCharStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("input.txt");

            // Convert bytes to characters 
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); 
            }

            
            br.close();
            isr.close();
            fis.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding not supported: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
