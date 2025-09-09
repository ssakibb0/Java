// public class NestedTryCatch {

//     public static void main(String[] args) {
//         // Array with 5 elements, arr[4] = 0
//         int[] arr = {12, 23, 34, 2, 0};

//         try {
//             // 🔥 Statement 1: Division by zero - this will throw ArithmeticException
//             int d = arr[0] / arr[4];  // 12 / 0 → ArithmeticException

//             // 🚫 Statement 2: Will never be executed because exception occurred above
//             System.out.println("division : " + d);

//             // 🚫 Statement 3: Will also not execute even if above worked
//             System.out.println(arr[5]); // Would have caused ArrayIndexOutOfBoundsException
//         } catch (Exception e) {
//             // ✅ This will catch any exception thrown above (superclass of all exceptions)
//             System.out.println("Caught Exception: " + e);
//         }

//         // 
//     }
// }

public class NestedTryExample {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try start");

            int[] arr = {1, 2, 3};

            // 🔽 Nested try block
            try {
                System.out.println("Inner try start");
                System.out.println(arr[5]); // ❌ ArrayIndexOutOfBoundsException
                System.out.println("Inner try end"); // Will be skipped
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught in INNER catch: " + e);
            }

            // 🔽 This will throw ArithmeticException
            int result = 10 / 0;

            System.out.println("Outer try end"); // ❌ Won't execute

        } catch (ArithmeticException e) {
            System.out.println("Caught in OUTER catch: " + e);
        }

        System.out.println("Program continues...");
    }
}
