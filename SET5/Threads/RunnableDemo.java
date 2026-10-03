class Task1 implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task 1: " + i);
        }
    }
}

class Task2 implements Runnable {
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Task 2: " + c);
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {

        Task1 task1 = new Task1();
        Task2 task2 = new Task2();

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
