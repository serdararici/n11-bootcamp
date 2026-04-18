package payment;

public class CreditCardPayment implements IPaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid with Credit Card: " + amount);
    }
}