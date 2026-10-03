import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeRecord {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            DataOutputStream dos =
                new DataOutputStream(new FileOutputStream("employee.dat"));

            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++) {

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                dos.writeInt(id);
                dos.writeUTF(name);
                dos.writeDouble(salary);
            }

            dos.close();

            DataInputStream dis =
                new DataInputStream(new FileInputStream("employee.dat"));

            System.out.println("\nEmployee Details");

            for (int i = 1; i <= n; i++) {

                int id = dis.readInt();
                String name = dis.readUTF();
                double salary = dis.readDouble();

                System.out.println("\nEmployee " + i);
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

            dis.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
