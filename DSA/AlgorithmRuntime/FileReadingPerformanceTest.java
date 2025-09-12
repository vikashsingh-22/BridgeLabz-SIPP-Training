package AlgorithmRuntime;

import java.io.*;

public class FileReadingPerformanceTest {

    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt"; // Replace with a 500MB+ file path

        // FileReader
        long startFR = System.currentTimeMillis();
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {
                // Reading char-by-char (simulate real use)
            }
        }
        long endFR = System.currentTimeMillis();
        System.out.println("FileReader time: " + (endFR - startFR) + " ms");

        // InputStreamReader
        long startISR = System.currentTimeMillis();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            while (isr.read() != -1) {
                // Reading char-by-char
            }
        }
        long endISR = System.currentTimeMillis();
        System.out.println("InputStreamReader time: " + (endISR - startISR) + " ms");
    }
}
