import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MyTask class implements Runnable interface
 * Is class ke andar define karte hain ki thread ko kya kaam karna hai (run method)
 */
class MyTask implements Runnable {
    private int taskId;

    // Constructor: task ko ek unique ID assign kar raha hai
    public MyTask(int id) {
        this.taskId = id;
    }

    /**
     * run() method jisme thread ka kaam define hota hai
     * Jab thread ye task run karega, yeh code chalega
     */
    @Override
    public void run() {
        System.out.println("Task " + taskId + " start hua by " + Thread.currentThread().getName());

        try {
            // Simulate kar rahe hain task ka kuch time-consuming kaam (1 second ka delay)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Agar thread interrupt ho jaye to exception handle karenge
            e.printStackTrace();
        }

        System.out.println("Task " + taskId + " khatam hua by " + Thread.currentThread().getName());
    }
}

/**
 * Main class jisme ThreadPoolExecutor ka use karke tasks submit karenge
 */
public class ThreadPoolExample {

    /**
     * main() method program ka entry point hai
     * Yahan hum thread pool create karenge, tasks submit karenge, aur pool ko shutdown karenge
     */
    public static void main(String[] args) {
        
        // 1. Thread pool create karo jisme 3 threads simultaneously chal sakte hain
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 2. Loop me 5 alag-alag tasks create kar ke thread pool me bhej rahe hain
        // Har task ek alag thread me ya thread pool ke available thread me chalega
        for (int i = 1; i <= 5; i++) {
            pool.submit(new MyTask(i));  // Submit task to thread pool
        }

        // 3. Shutdown pool after submitting all tasks
        // Iska matlab hai ki ab pool naye tasks accept nahi karega
        pool.shutdown();
    }
}
