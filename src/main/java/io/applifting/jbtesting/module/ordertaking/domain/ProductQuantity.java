package io.applifting.jbtesting.module.ordertaking.domain;

import java.util.Objects;

public class ProductQuantity {
    private final int quantity;

    public ProductQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductQuantity that)) return false;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
