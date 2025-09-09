public class ExceptionPropagationExample {

    // ✅ method1: Ye method ArithmeticException throw karta hai
    static void method1() {
        System.out.println("Inside method1");

        // ❌ This will throw ArithmeticException (Divide by zero)
        int a = 10 / 0;
    }

    // ✅ method2: Ye method method1 ko call karta hai, but khud exception handle nahi karta
    static void method2() {
        System.out.println("Inside method2");

        // 🔁 If exception occurs in method1, it will propagate to method2
        method1();
    }

    // ✅ method3: Ye method method2 ko call karta hai, yaha pe exception HANDLE ki ja rahi hai
    static void method3() {
        System.out.println("Inside method3");

        // 🔒 Exception handling done here using try-catch
        try {
            method2(); // method2 → method1 → exception
        } catch (ArithmeticException e) {
            // ✅ Exception finally caught here
            System.out.println("Caught exception in method3: " + e);
        }
    }

    public static void main(String[] args) {
        // 📍 Program execution starts from main
        method3(); // Starts the chain of calls

        // ✅ Since exception was caught successfully, program continues
        System.out.println("Program continues...");
    }
}
