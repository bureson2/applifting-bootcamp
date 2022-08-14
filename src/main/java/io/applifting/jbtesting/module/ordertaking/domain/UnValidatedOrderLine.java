package io.applifting.jbtesting.module.ordertaking.domain;

public class UnValidatedOrderLine {
    public final String productCode;
    public final int amount;

    public UnValidatedOrderLine(String productCode, int amount) {
        this.productCode = productCode;
        this.amount = amount;
    }
}
