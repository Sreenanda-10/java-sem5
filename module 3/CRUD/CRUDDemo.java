import java.sql.*;

class CRUDDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();

            // INSERT
            st.executeUpdate(
                "INSERT INTO student VALUES (1, 'Anu', 19, 85.5)"
            );
            System.out.println("Record inserted");

            // UPDATE
            st.executeUpdate(
                "UPDATE student SET marks=90 WHERE id=1"
            );
            System.out.println("Record updated");

            // SELECT
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age") + " " +
                    rs.getDouble("marks")
                );
            }

            rs.close();

            // DELETE
            st.executeUpdate("DELETE FROM student WHERE id=1");
            System.out.println("Record deleted");

            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
