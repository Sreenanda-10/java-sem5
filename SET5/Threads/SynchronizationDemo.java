class BankAccount {
    int balance = 1000;

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName()
                    + " is withdrawing " + amount);

            balance = balance - amount;

            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " - Insufficient balance");
        }
    }
}

class Customer extends Thread {
    BankAccount account;

    Customer(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    public void run() {
        account.withdraw(700);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Customer c1 = new Customer(account, "Customer 1");
        Customer c2 = new Customer(account, "Customer 2");

        c1.start();
        c2.start();
    }
}
