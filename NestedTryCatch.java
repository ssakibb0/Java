public class NestedTryCatch {

    public static void main(String[] args) {
        // Array with 5 elements, arr[4] = 0
        int[] arr = {12, 23, 34, 2, 0};

        try {
            // 🔥 Statement 1: Division by zero - this will throw ArithmeticException
            int d = arr[0] / arr[4];  // 12 / 0 → ArithmeticException

            // 🚫 Statement 2: Will never be executed because exception occurred above
            System.out.println("division : " + d);

            // 🚫 Statement 3: Will also not execute even if above worked
            System.out.println(arr[5]); // Would have caused ArrayIndexOutOfBoundsException
        } catch (Exception e) {
            // ✅ This will catch any exception thrown above (superclass of all exceptions)
            System.out.println("Caught Exception: " + e);
        }
    }
}
