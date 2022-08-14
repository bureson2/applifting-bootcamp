package io.applifting.jbtesting.module.ordertaking.domain;

import java.util.Collection;
import java.util.Objects;

public class ValidatedOrder {
    private final CustomerInfo customerInfo;
    private final Collection<ValidatedOrderLine> orderLines;

    public ValidatedOrder(CustomerInfo customerInfo, Collection<ValidatedOrderLine> orderLines) {
        this.customerInfo = customerInfo;
        this.orderLines = orderLines;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public Collection<ValidatedOrderLine> getOrderLines() {
        return orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidatedOrder that)) return false;
        return Objects.equals(customerInfo, that.customerInfo) && Objects.equals(orderLines, that.orderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerInfo, orderLines);
    }
}
