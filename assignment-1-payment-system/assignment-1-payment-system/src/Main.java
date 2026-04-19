import factory.PaymentFactory;
import logging.AbstractLogger;
import logging.ConsoleLogger;
import payment.IPaymentMethod;
import service.PaymentService;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AbstractLogger logger = new ConsoleLogger();
        PaymentService paymentService = new PaymentService(logger);

        // 1. Map selection keys to class names (Configuration)
        Map<Integer, String> paymentMethods = new HashMap<>();
        paymentMethods.put(1, "CreditCardPayment");
        paymentMethods.put(2, "PayPalPayment");
        //paymentMethods.put(3, "ApplePayPayment"); // New method? Just add one line here.

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

                //Get payment class with factory and it is using reflection
                //get the class name from the map.
                String className = paymentMethods.get(choice);
                // 3. Create object via Reflection
                IPaymentMethod paymentMethod = PaymentFactory.createPayment(className);

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