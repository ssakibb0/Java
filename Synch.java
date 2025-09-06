// Class extending Thread to create custom threads
public class Synch extends Thread {

    // Static counter shared among all threads
    static int counter = 0;

    // 🔒 Synchronized static method to safely increment counter
    // This ensures only one thread can access this method at a time
    // Static method uses class-level lock (Synch.class)
    public static synchronized void increment() {
        counter++;
    }

    // This method is executed when the thread starts
    @Override
    public void run() {
        // Loop 1000 times to increment the shared counter
        for (int i = 0; i < 1000; i++) {
            increment(); // Calls the synchronized method
        }

        // Print message after this thread finishes its work
        System.out.println(Thread.currentThread().getName() + " finished");
    }

    // Main method: program execution starts here
    public static void main(String[] args) throws InterruptedException {

        // Create two thread objects
        Synch t1 = new Synch();
        Synch t2 = new Synch();

        // Set names for easier output identification
        t1.setName("Thread-1");
        t2.setName("Thread-2");

        // Start both threads — run() method will be called
        t1.start();
        t2.start();

        // 🔁 join(): Main thread waits for t1 and t2 to finish
        // If you don’t join, main thread may print the counter too early
        t1.join(); // Waits for Thread-1 to complete
        t2.join(); // Waits for Thread-2 to complete

        // After both threads finish, print the final counter value
        System.out.println("Final counter: " + counter); // Expected: 2000
    }
}
