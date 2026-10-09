import java.sql.*;
import java.util.Scanner;

class StudentRegistration {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            // Insert student details
            String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setDouble(4, marks);

            ps.executeUpdate();

            System.out.println("Student registered successfully!");

            // Search student
            System.out.print("Enter ID to search: ");
            int searchId = sc.nextInt();

            PreparedStatement search = con.prepareStatement(
                "SELECT * FROM student WHERE id = ?"
            );

            search.setInt(1, searchId);

            ResultSet rs = search.executeQuery();

            if (rs.next()) {
                System.out.println("Student Details:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Marks: " + rs.getDouble("marks"));
            } else {
                System.out.println("Student not found");
            }

            rs.close();
            search.close();
            ps.close();
            con.close();
            sc.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
