package io.applifting.jbtesting.module.ordertaking.domain;

public class InvalidProductQuantityError extends Exception {
    public InvalidProductQuantityError(int quantity, int maxLimit) {
        super("Given product quantity '%s' must be (0; %s>".formatted(quantity, maxLimit));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidProductQuantityError error)) return false;
        return error.getMessage().equals(this.getMessage());
    }
}
