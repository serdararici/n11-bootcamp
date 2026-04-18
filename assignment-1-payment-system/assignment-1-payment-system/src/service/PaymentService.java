package service;

import logging.AbstractLogger;
import payment.IPaymentMethod;

public class PaymentService {

    private final AbstractLogger logger;

    public PaymentService(AbstractLogger logger) {
        this.logger = logger;
    }

    public void processPayment(IPaymentMethod method, double amount) {
        // Log start of the operation
        logger.log("Attempting to process payment for amount: " + amount);

        // 1. Validation Logic
        if (amount <= 0) {
            logger.log("[ERROR] Invalid payment amount: " + amount);
            throw new IllegalArgumentException("Amount must be greater than 0!");
        }

        if (method == null) {
            logger.log("[ERROR] Payment method is null");
            throw new IllegalArgumentException("Payment method cannot be null");
        }

        // 2. Execution Logic
        try {
            method.pay(amount);
            logger.log("[INFO] Payment completed successfully. Amount: " + amount + " Method: " + method.getClass().getSimpleName());
        } catch (Exception e) {
            logger.log("[CRITICAL] Payment failed: " + e.getMessage());
            throw e; // Re-throw to inform the UI/Main
        }
    }
}