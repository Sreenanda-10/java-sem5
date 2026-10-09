import java.sql.*;
import java.io.*;

class BlobClobDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "your_password";

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            // Store image and document
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO documents VALUES (?, ?, ?)"
            );

            ps.setInt(1, 1);

            FileInputStream image =
                new FileInputStream("photo.jpg");

            FileReader document =
                new FileReader("document.txt");

            ps.setBinaryStream(2, image);
            ps.setCharacterStream(3, document);

            ps.executeUpdate();

            image.close();
            document.close();
            ps.close();

            System.out.println("Image and document stored successfully");

            // Retrieve image and document
            PreparedStatement search = con.prepareStatement(
                "SELECT image_data, text_data FROM documents WHERE id = ?"
            );

            search.setInt(1, 1);

            ResultSet rs = search.executeQuery();

            if (rs.next()) {
                try (InputStream in = rs.getBinaryStream("image_data");
                     FileOutputStream out =
                         new FileOutputStream("retrieved.jpg")) {

                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                try (Reader reader = rs.getCharacterStream("text_data");
                     FileWriter writer =
                         new FileWriter("retrieved.txt")) {

                    char[] buffer = new char[4096];
                    int charsRead;

                    while ((charsRead = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, charsRead);
                    }
                }

                System.out.println("Image retrieved successfully");
                System.out.println("Document retrieved successfully");
            }

            rs.close();
            search.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
