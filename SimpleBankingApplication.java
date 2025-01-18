import java.util.Scanner;

public class SimpleBankingApplication {

    private static double balance = 0.0; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Simple Banking Application!");

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to check balance
    private static void checkBalance() {
        System.out.println("Your current balance is: $" + String.format("%.2f", balance));
    }

    // Method to deposit money
    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + String.format("%.2f", amount));
        } else {
            System.out.println("Invalid amount. Deposit must be greater than 0.");
        }
    }

    // Method to withdraw money
    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + String.format("%.2f", amount));
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Unable to process the withdrawal.");
        } else {
            System.out.println("Invalid amount. Withdrawal must be greater than 0.");
        }
    }
}