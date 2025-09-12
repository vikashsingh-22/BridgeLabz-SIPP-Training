package LinearandBinarySearch.InputStreamReader;

import java.io.*;

public class ConsoleToWriter {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // Write to file
            FileWriter fw = new FileWriter("output.txt");

            System.out.println("Enter text (type 'exit' to finish):");

            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + "\n"); 
            }

           
            System.out.println("User input saved to output.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
