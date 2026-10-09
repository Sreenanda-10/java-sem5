import java.sql.*;

class CallableDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            CallableStatement cs =
                con.prepareCall("{CALL GetStudents()}");

            ResultSet rs = cs.executeQuery();

            System.out.println("Student Records:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age") + " " +
                    rs.getDouble("marks")
                );
            }

            rs.close();
            cs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
