package payment;

public class PayPalPayment implements IPaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid with PayPal: " + amount);
    }
}