package service.validation;

import logging.AbstractLogger;
import payment.IPaymentMethod;

public class AmountValidator extends PaymentValidator {

    public AmountValidator(AbstractLogger logger) {
        super(logger);
    }

    @Override
    public void validate(double amount, IPaymentMethod method) {
        // Logging the specific validation step
        logger.log("[VALIDATION] Checking payment amount: " + amount);

        if (amount <= 0) {
            logger.log("[ERROR] Validation failed: Negative or zero amount.");
            throw new IllegalArgumentException("Amount must be greater than 0!");
        }

        if (next != null) next.validate(amount, method);
    }
}