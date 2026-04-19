package factory;

import payment.IPaymentMethod;

public class PaymentFactory {

    /**
     * Creates payment instances using Reflection to satisfy Open/Closed Principle.
     * As mentioned in the bootcamp, this avoids switch-case blocks.
     */
    public static IPaymentMethod createPayment(String className) {
        if (className == null || className.isEmpty()) {
            return null;
        }
        try {
            String fullPath = "payment." + className;
            return (IPaymentMethod) Class.forName(fullPath)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unknown payment type: " + className);
        } catch (Exception e) {
            throw new RuntimeException("Payment instantiation failed: " + className, e);
        }
    }
}