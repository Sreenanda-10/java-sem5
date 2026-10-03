import java.util.Scanner;

public class MultipleExceptions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter array index: ");
            int index = sc.nextInt();

            System.out.print("Enter divisor: ");
            int divisor = sc.nextInt();

            System.out.println("Array value: " + numbers[index]);

            int result = numbers[index] / divisor;

            System.out.println("Result: " + result);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
        finally {
            System.out.println("Exception handling completed");
        }

        sc.close();
    }
}
