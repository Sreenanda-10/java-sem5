import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {
    public static void main(String[] args) {

        try {
            // Writing student details
            DataOutputStream dos =
                new DataOutputStream(new FileOutputStream("student.dat"));

            dos.writeInt(101);
            dos.writeUTF("Sreenanda");
            dos.writeDouble(85.5);

            dos.close();

            // Reading student details
            DataInputStream dis =
                new DataInputStream(new FileInputStream("student.dat"));

            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double marks = dis.readDouble();

            dis.close();

            System.out.println("Student Details");
            System.out.println("Roll Number: " + rollNo);
            System.out.println("Name: " + name);
            System.out.println("Marks: " + marks);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
