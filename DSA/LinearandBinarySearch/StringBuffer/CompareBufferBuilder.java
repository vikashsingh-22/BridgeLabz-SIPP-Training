package LinearandBinarySearch.StringBuffer;
public class CompareBufferBuilder {
    public static void main(String[] args) {
        int n = 1000000;

        // Measure performance of StringBuilder vs StringBuffer
        System.out.println("Performance comparison of StringBuilder and StringBuffer for " + n + " iterations:");
        long start1 = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append("hello");
        }
        long end1 = System.nanoTime();
        System.out.println("StringBuilder time: " + (end1 - start1) / 1_000_000 + " ms");

        long start2 = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            buffer.append("hello");
        }
        long end2 = System.nanoTime();
        System.out.println("StringBuffer time : " + (end2 - start2) / 1_000_000 + " ms");
    }
}
