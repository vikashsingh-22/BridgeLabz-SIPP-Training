package JavaStreams;
import java.io.*;

public class StudentDataBinaryIO {
    public static void main(String[] args) {
        String fileName = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);                     // Roll number
            dos.writeUTF("Arjun Raghav");          // Name
            dos.writeDouble(8.75);                 // GPA

            dos.writeInt(102);
            dos.writeUTF("Priya Sharma");
            dos.writeDouble(9.2);

            dos.writeInt(103);
            dos.writeUTF("Rahul Mehta");
            dos.writeDouble(7.9);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Reading data from binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nReading student data from file:");
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
