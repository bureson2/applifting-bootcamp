package io.applifting.jbtesting.module.ordertaking.domain;

import java.util.Objects;

public class ValidatedOrderLine {
    private final ProductCode productCode;
    private final ProductQuantity productQuantity;

    public ValidatedOrderLine(ProductCode productCode, ProductQuantity productQuantity) {
        this.productCode = productCode;
        this.productQuantity = productQuantity;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public ProductQuantity getProductQuantity() {
        return productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidatedOrderLine that)) return false;
        return Objects.equals(productCode, that.productCode) && Objects.equals(productQuantity, that.productQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productQuantity);
    }
}
