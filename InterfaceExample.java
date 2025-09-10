// -------------------- INTERFACE --------------------
interface BankAccount {

    // 1. ABSTRACT METHOD
    // - Definition: A method without a body (implementation).
    // - Concern: Defines a "must-have" behavior for all implementing classes.
    // - Why use it? -> To enforce a contract (e.g., all bank accounts must implement withdraw).
    // - Alternate? -> Abstract class can also enforce, but then multiple inheritance is not possible.
    void withdraw(double amount);

    // 2. DEFAULT METHOD
    // - Definition: A method in interface with a body (Java 8+).
    // - Concern: Provides backward compatibility. If later we add new methods,
    //   old classes will not break because they inherit default behavior.
    // - Why use it? -> To provide a "default behavior" that classes may override if needed.
    // - Alternate? -> Earlier we used abstract classes to achieve this.
    default void deposit(double amount) {
        System.out.println("Deposited " + amount + " (default behavior)");
    }

    // 3. STATIC METHOD
    // - Definition: A method that belongs to the interface itself, not to objects.
    // - Concern: Utility/helper method related to the interface.
    // - Why use it? -> To avoid creating separate Utility classes (like Collections, Arrays).
    //   Can be called directly using InterfaceName.methodName().
    // - Alternate? -> Earlier we used external Utility classes.
    static boolean validateAmount(double amount) {
        return amount > 0;
    }
}

// -------------------- IMPLEMENTING CLASS --------------------
class SavingsAccount implements BankAccount {
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    // Must implement the abstract method
    @Override
    public void withdraw(double amount) {
        if (BankAccount.validateAmount(amount) && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Remaining Balance: " + balance);
        } else {
            System.out.println("Invalid withdraw attempt");
        }
    }

    // Optional: Override default method
    @Override
    public void deposit(double amount) {
        if (BankAccount.validateAmount(amount)) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
}

// -------------------- DEMO --------------------
public class InterfaceExample {
    public static void main(String[] args) {
        // Create object
        BankAccount account = new SavingsAccount(1000);

        // 1. Abstract method -> must be implemented by class
        account.withdraw(200);

        // 2. Default method -> can use inherited OR overridden version
        account.deposit(500);

        // 3. Static method -> called using interface name (not object)
        System.out.println("Is valid amount? " + BankAccount.validateAmount(-50));
    }
}
