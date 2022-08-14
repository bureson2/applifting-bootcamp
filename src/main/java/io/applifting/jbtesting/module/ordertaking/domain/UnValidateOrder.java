package io.applifting.jbtesting.module.ordertaking.domain;

import java.util.Collection;

public class UnValidateOrder {
    public final UnValidatedCustomerInfo customerInfo;
    public final Collection<UnValidatedOrderLine> orderLines;

    public UnValidateOrder(UnValidatedCustomerInfo customerInfo, Collection<UnValidatedOrderLine> orderLines) {
        this.customerInfo = customerInfo;
        this.orderLines = orderLines;
    }
}
