package JavaStreams;

import java.io.*;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";
        String outputImagePath = "output.jpg";
        if (args.length > 0) {
            inputImagePath = args[0];
            outputImagePath = args[1];
        }
        try {
            byte[] imageBytes = convertImageToByteArray(inputImagePath);
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");

            writeByteArrayToImage(imageBytes, outputImagePath);
            System.out.println("Byte array written to new image file: " + outputImagePath);

            boolean isIdentical = verifyImages(inputImagePath, outputImagePath);
            System.out.println("Original and new images are identical: " + isIdentical);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    private static boolean verifyImages(String originalPath, String newPath) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(originalPath);
             FileInputStream fis2 = new FileInputStream(newPath)) {
            byte[] originalBytes = fis1.readAllBytes();
            byte[] newBytes = fis2.readAllBytes();
            return Arrays.equals(originalBytes, newBytes);
        }
    }
}
