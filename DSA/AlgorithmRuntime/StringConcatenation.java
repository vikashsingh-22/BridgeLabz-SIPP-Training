package AlgorithmRuntime;

public class StringConcatenation {
    
    public static void main(String[] args) {
        int size = 10000; // Size of the string to concatenate
        String str = "Hello, World! ";

        // Using StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(str);
        }
        String resultBuilder = sb.toString();
        long timeBuilder = System.nanoTime() - startBuilder;

        // Using String concatenation
        long startConcat = System.nanoTime();
        String resultConcat = "";
        for (int i = 0; i < size; i++) {
            resultConcat += str;
        }
        long timeConcat = System.nanoTime() - startConcat;

        // Print results
        System.out.println("StringBuilder Time: " + timeBuilder / 1e6 + " ms");
        System.out.println("String Concatenation Time: " + timeConcat / 1e6 + " ms");
    }
}
