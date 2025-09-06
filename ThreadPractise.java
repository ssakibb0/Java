
// class ThreadPractise extends  Thread{

//     @Override
//     public void run(){
//         System.out.println("Running");
//     }
//     public static void main(String[] args) throws InterruptedException{
//         // Thread t1 = new Thread(); 
//         ThreadPractise t1 = new ThreadPractise(); // ✅ Correct: run() override hua hai

//         System.out.println(t1.getState());
//         t1.start();
//         System.out.println(t1.getState());
//         System.out.println(Thread.currentThread().getState());
//         Thread.sleep(1000);
//         // System.out.println(t1.getState());
//     }
// }








class ThreadPractise extends Thread {
    @Override
    public void run() {
        System.out.println("Running");
        try{
            Thread.sleep(5000);
            System.out.println("Running inside try");
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPractise t1 = new ThreadPractise();  // ✅ use subclass
        System.out.println("Before start: " + t1.getState());
        t1.start(); // will call run()
        System.out.println("After start: " + t1.getState());
        System.out.println("Main thread state: " + Thread.currentThread().getState());
        Thread.sleep(1000);
        System.out.println("After sleep: " + t1.getState()); // likely TERMINATED
        t1.join();
        System.out.println(t1.getState());
    }
}
