import factory.PaymentFactory;
import logging.AbstractLogger;
import logging.ConsoleLogger;
import payment.IPaymentMethod;
import service.PaymentService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AbstractLogger logger = new ConsoleLogger();
        PaymentService paymentService = new PaymentService(logger);

        System.out.println("####################################");
        System.out.println("#     Welcome to Payment System    #");
        System.out.println("####################################\n");

        boolean continuePayment = true;

        while (continuePayment) {
            try {
                System.out.println("\nSelect Payment Method:");
                System.out.println("1 - Credit Card");
                System.out.println("2 - PayPal");
                System.out.println("0 - Exit");
                System.out.print("\nYour choice: ");

                int choice = scanner.nextInt();

                if (choice == 0) {
                    logger.log("User exited the system.");
                    break;
                }

                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();

                IPaymentMethod paymentMethod = PaymentFactory.createPayment(choice);

                //service handles everything
                paymentService.processPayment(paymentMethod, amount);

                System.out.println("\nPayment completed successfully!");

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numeric values.");
                logger.log("[WARNING] User entered non-numeric input.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                // This catches the validation errors from service
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

            System.out.println("\n------------------------------------");
        }
        scanner.close();
    }
}