import factory.PaymentFactory;
import payment.IPaymentMethod;
import payment.PaymentService;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PaymentService paymentService = new PaymentService();

        System.out.println("####################################");
        System.out.println("#     Welcome to Payment System    #");
        System.out.println("####################################\n");

        boolean continuePayment = true;

        // Main loop allows user to make multiple payments
        while (continuePayment) {

            try {
                System.out.println("\nSelect Payment Method:");
                System.out.println("1 - Credit Card");
                System.out.println("2 - PayPal");
                System.out.println("0 - Exit");

                System.out.print("\nYour choice: ");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Exiting system...");
                    break;
                }

                System.out.print("Enter amount to pay (₺): ");
                double amount = scanner.nextDouble();

                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0!");
                    continue;
                }

                IPaymentMethod paymentMethod;

                // Used factory pattern here
                paymentMethod = PaymentFactory.createPayment(choice);

                System.out.println("\nProcessing payment...\n");
                paymentService.processPayment(paymentMethod, amount);

                System.out.println("\nPayment completed successfully!");

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numeric values only.");
                scanner.nextLine(); // clear invalid input buffer
            }

            System.out.println("\n------------------------------------");
        }

        scanner.close();
    }
}