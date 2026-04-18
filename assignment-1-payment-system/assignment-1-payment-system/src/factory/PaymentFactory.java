package factory;


import payment.IPaymentMethod;
import payment.PayPalPayment;
import service.CreditCardPayment;

public class PaymentFactory {

// Factory Pattern is used here to encapsulate object creation logic.
// This improves code maintainability and follows SOLID principles,
// especially Open/Closed Principle (OCP).

    // Creates payment method based on user selection
    public static IPaymentMethod createPayment(int choice) {

        switch (choice) {
            case 1:
                return new CreditCardPayment();
            case 2:
                return new PayPalPayment();
            default:
                throw new IllegalArgumentException("Invalid payment method selected");
        }
    }
}