package service.validation;

import logging.AbstractLogger;
import payment.IPaymentMethod;

public class MethodValidator extends PaymentValidator {

    public MethodValidator(AbstractLogger logger) {
        super(logger);
    }

    @Override
    public void validate(double amount, IPaymentMethod method) {
        logger.log("[VALIDATION] Checking payment method instance.");

        if (method == null) {
            logger.log("[ERROR] Validation failed: Payment method is null.");
            throw new IllegalArgumentException("Payment method cannot be null!");
        }

        if (next != null) next.validate(amount, method);
    }
}