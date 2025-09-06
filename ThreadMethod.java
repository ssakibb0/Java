public class ThreadMethod extends Thread{

    public ThreadMethod(String name) {
        super(name);
    }
    
    public void run(){
        
        for(int i=0;i<5;i++){
            
            System.out.println(Thread.currentThread().getName() +"- priority "+Thread.currentThread().getPriority() + "- count " + i);
        }
    }

    public static void main(String[] args) {
        ThreadMethod l = new ThreadMethod("low priority thread");
        ThreadMethod m = new ThreadMethod("Medium priority thread");
        ThreadMethod h = new ThreadMethod("high priority thread");
        l.setPriority(MIN_PRIORITY);
        m.setPriority(NORM_PRIORITY);
        h.setPriority(MAX_PRIORITY);

        l.start();
        m.start();
        h.start();

    }
}