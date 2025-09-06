// ThreadMethod class Thread ko extend karti hai — iska matlab hai yeh ek custom thread class hai
public class ThreadMethod extends Thread {

    // Constructor: Thread ko name dene ke liye use hota hai
    // super(name) se hum parent Thread class ka constructor call kar rahe hai
    public ThreadMethod(String name) {
        super(name); // Thread ka naam set karega (useful for debugging)
    }

    // run() method: Jab thread start hoga to ye method chalega
    public void run() {
        // Loop 5 times chalega — har baar thread ka naam, priority aur count print hoga
        for (int i = 0; i < 5; i++) {
            // Thread.currentThread() — currently executing thread ka reference deta hai
            // getName() — thread ka naam deta hai
            // getPriority() — thread ki priority (1 to 10)
            System.out.println(Thread.currentThread().getName() + 
                               " - priority " + Thread.currentThread().getPriority() +
                               " - count " + i);
        }
    }

    // main() method: Program yahan se start hota hai
    public static void main(String[] args) {

        // Teen thread objects banaye gaye: low, medium, high priority
        ThreadMethod l = new ThreadMethod("low priority thread");
        ThreadMethod m = new ThreadMethod("Medium priority thread");
        ThreadMethod h = new ThreadMethod("high priority thread");

        // Threads ko alag-alag priority di gayi hai:
        l.setPriority(MIN_PRIORITY);     // MIN_PRIORITY = 1 (sabse kam)
        m.setPriority(NORM_PRIORITY);    // NORM_PRIORITY = 5 (default)
        h.setPriority(MAX_PRIORITY);     // MAX_PRIORITY = 10 (sabse zyada)

        // Threads ko start kiya gaya — teeno almost same time par chalenge
        l.start();
        m.start();
        h.start();

        // Note: Thread scheduling JVM/OS ke upar hoti hai
        // High priority ka matlab hota hai: CPU zyada preference de sakta hai
        // Lekin yeh guarantee nahi hoti ki wo pehle chale hi
    }
}
