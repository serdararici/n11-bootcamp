package payment;

public class PaymentService {

    public void processPayment(IPaymentMethod method, double amount) {
        method.pay(amount);
    }
}