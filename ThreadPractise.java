// ThreadPractise class Thread ko extend karti hai
// Iska matlab ye ek custom thread class hai
class ThreadPractise extends Thread {

    // run() method override kiya gaya hai — ye thread start hone par chalega
    @Override
    public void run() {
        // Jab thread chalu hoga, ye message print hoga
        System.out.println("Running");
        try {
            // Thread ko 5 seconds ke liye sula diya (sleep)
            Thread.sleep(5000);  // sleep se thread TIMED_WAITING state me chala jata hai
            System.out.println("Running inside try"); // ye tab chalega jab 5s complete honge
        } catch (InterruptedException e) {
            // Agar thread ko kisi ne interrupt kiya, toh yeh catch block chalega
            System.out.println(e); // exception ka message print karega
        }
    }

    // main() method — Java program yahin se start hota hai
    public static void main(String[] args) throws InterruptedException {

        // ThreadPractise class ka ek object banaya gaya (ye thread hai)
        ThreadPractise t1 = new ThreadPractise();

        // Thread ko start karne se pehle uska state print kar rahe hai
        // Is time pe thread NEW state me hota hai (kyuki start() nahi hua abhi tak)
        System.out.println("Before start: " + t1.getState());

        // Thread ko start kiya — ye run() method ko call karega
        t1.start();

        // start() call karne ke turant baad thread RUNNABLE state me chala jata hai
        // Lekin exact state scheduling pe depend karta hai
        System.out.println("After start: " + t1.getState());

        // Ye main thread ka state print karega — mostly RUNNABLE hi hota hai
        System.out.println("Main thread state: " + Thread.currentThread().getState());

        // Main thread ko 1 second ke liye sleep kar rahe hai
        // Is time pe background me t1 thread chal raha hoga
        Thread.sleep(1000);

        // 1 second ke baad t1 ka state check kar rahe hai
        // Agar t1 abhi bhi 5 second ka sleep me hai, toh uska state TIMED_WAITING dikhega
        System.out.println("After sleep: " + t1.getState());

        // join() ka matlab: main thread wait karega jab tak t1 khatam nahi hota
        t1.join();

        // Ab t1 thread terminate ho chuka hoga, isliye state TERMINATED dikhega
        System.out.println(t1.getState());
    }
}
