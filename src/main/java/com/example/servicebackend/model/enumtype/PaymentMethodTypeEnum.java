package com.example.servicebackend.model.enumtype;

public enum PaymentMethodTypeEnum {
    PERSONAL_WALLET("Personal Wallet"),
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    CASH("Cash"),
    PAYPAL("Paypal"),
    GOOGLE_PAY("Google Pay"),
    APPLE_PAY("Apple Pay"),
    OTHERS("Others");

    private final String paymentMethodType;

    PaymentMethodTypeEnum(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }
}
