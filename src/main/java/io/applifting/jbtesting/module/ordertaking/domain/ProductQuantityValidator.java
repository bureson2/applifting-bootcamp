package io.applifting.jbtesting.module.ordertaking.domain;

public class ProductQuantityValidator {
    private final int maxLimit;

    public ProductQuantityValidator(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public ProductQuantity validate(int quantity) throws InvalidProductQuantityError {
        if (0 < quantity && quantity <= maxLimit) {
            return new ProductQuantity(quantity);
        } else {
            throw new InvalidProductQuantityError(quantity, maxLimit);
        }
    }
}
