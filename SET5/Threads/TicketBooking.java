class TicketCounter {
    int tickets = 5;

    synchronized void bookTicket(int number) {
        if (tickets >= number) {
            System.out.println(Thread.currentThread().getName()
                    + " booked " + number + " ticket(s).");

            tickets = tickets - number;

            System.out.println("Remaining tickets: " + tickets);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " - Not enough tickets available.");
        }
    }
}

class Customer extends Thread {
    TicketCounter counter;

    Customer(TicketCounter counter, String name) {
        super(name);
        this.counter = counter;
    }

    public void run() {
        counter.bookTicket(2);
    }
}

public class TicketBooking {
    public static void main(String[] args) {

        TicketCounter counter = new TicketCounter();

        Customer c1 = new Customer(counter, "Customer 1");
        Customer c2 = new Customer(counter, "Customer 2");
        Customer c3 = new Customer(counter, "Customer 3");

        c1.start();
        c2.start();
        c3.start();
    }
}
