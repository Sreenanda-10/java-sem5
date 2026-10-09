import java.sql.*;

public class BankTransaction {
    public static void main(String[] args) {
        Connection con = null;

        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "your_password"
            );

            con.setAutoCommit(false);

            Statement st = con.createStatement();

            // Deduct money from account 1
            int debit = st.executeUpdate(
                "UPDATE bank SET balance = balance - 500 " +
                "WHERE account_no = 1 AND balance >= 500"
            );

            if (debit == 0) {
                throw new SQLException(
                    "Account 1 not found or insufficient balance."
                );
            }

            // Add money to account 2
            int credit = st.executeUpdate(
                "UPDATE bank SET balance = balance + 500 " +
                "WHERE account_no = 2"
            );

            if (credit == 0) {
                throw new SQLException("Account 2 not found.");
            }

            con.commit();

            System.out.println("Transaction successful!");
            System.out.println("Rs. 500 transferred.");

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("Transaction failed. Changes rolled back.");
            System.out.println(e.getMessage());

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
