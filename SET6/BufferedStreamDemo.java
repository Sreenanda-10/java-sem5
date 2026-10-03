import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamDemo {
    public static void main(String[] args) {

        try {
            BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream("source.txt"));

            BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream("destination.txt"));

            int ch;

            while ((ch = bis.read()) != -1) {
                bos.write(ch);
            }

            bos.flush();

            bis.close();
            bos.close();

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
