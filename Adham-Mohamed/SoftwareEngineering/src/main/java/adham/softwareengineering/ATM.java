package adham.softwareengineering;
import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        double balance;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial balance: ");
        balance = scanner.nextDouble();
        int choice;
        boolean exit = false;
        while (!exit) { 
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Your balance is: " + balance);
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                if (amount > balance) {
                    System.out.println("Insufficient funds");
                } else {
                    balance -= amount;
                    System.out.println("You have withdrawn: " + amount);
                    System.out.println("Your new balance is: " + balance);
                }
            } else if (choice == 3) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                balance += amount;
                System.out.println("You have deposited: " + amount);
                System.out.println("Your new balance is: " + balance);
            } else if (choice == 4) {
                exit = true;
                System.out.println("Thank you for using the ATM. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
