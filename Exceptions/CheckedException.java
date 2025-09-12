import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class CheckedException {

    public static void main(String[] args) {
        Path filePath = Paths.get("data.txt");

        try (Stream<String> lines = Files.lines(filePath)) {
            System.out.println("--- File Content ---");
            lines.forEach(System.out::println);
            System.out.println("--- End of File ---");
        } catch (IOException e) {
            System.err.println("Error: File not found or cannot be read.");
        }
    }
}