package service.validation;

import logging.AbstractLogger;
import payment.IPaymentMethod;

public abstract class PaymentValidator {
    protected PaymentValidator next;
    protected AbstractLogger logger; // Added to use the system logger

    public PaymentValidator(AbstractLogger logger) {
        this.logger = logger;
    }

    public void setNext(PaymentValidator next) {
        this.next = next;
    }

    public abstract void validate(double amount, IPaymentMethod method);
}