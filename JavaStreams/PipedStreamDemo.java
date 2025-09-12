package JavaStreams;
import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect input to output

            Thread writer = new Thread(() -> {
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos))) {
                    String[] messages = {
                        "Hello from writer thread!",
                        "Piped streams are powerful.",
                        "This is inter-thread communication.",
                        "End"
                    };

                    for (String msg : messages) {
                        bw.write(msg);
                        bw.newLine();
                        bw.flush(); // Ensure it's sent
                        Thread.sleep(1000); // Simulate delay
                    }
                } catch (IOException | InterruptedException e) {
                    System.err.println("Writer Error: " + e.getMessage());
                }
            });

            // Reader Thread
            Thread reader = new Thread(() -> {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(pis))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println("Reader received: " + line);
                    }
                } catch (IOException e) {
                    System.err.println("Reader Error: " + e.getMessage());
                }
            });

            reader.start();
            writer.start();

            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Main Error: " + e.getMessage());
        }
    }
}

