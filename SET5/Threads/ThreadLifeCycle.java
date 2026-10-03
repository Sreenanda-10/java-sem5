class ThreadLifeCycle extends Thread {

    public void run() {
        System.out.println("Thread is Running");

        try {
            Thread.sleep(2000);
            System.out.println("Thread is in Timed Waiting state");
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread execution completed");
    }

    public static void main(String[] args) {

        ThreadLifeCycle t = new ThreadLifeCycle();

        System.out.println("Thread is in New state");

        t.start();

        System.out.println("Thread is in Runnable state");
    }
}
