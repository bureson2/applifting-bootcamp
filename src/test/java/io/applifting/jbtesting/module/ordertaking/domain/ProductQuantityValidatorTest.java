package io.applifting.jbtesting.module.ordertaking.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductQuantityValidatorTest {
    private static final int MAX_LIMIT = 1000;

    @Test
    void shouldReturnProductQuantity() throws InvalidProductQuantityError {
        assertEquals(
            new ProductQuantity(10),
            new ProductQuantityValidator(MAX_LIMIT).validate(10)
        );
    }

    @Test
    void shouldReturnInvalidProductQuantityErrorQuantityIsNotPositive() {
        int quantity = 0;
        InvalidProductQuantityError error = assertThrows(
            InvalidProductQuantityError.class,
            () -> new ProductQuantityValidator(MAX_LIMIT).validate(quantity)
        );
        assertEquals(
            new InvalidProductQuantityError(quantity, 1000),
            error
        );
    }

    @Test
    void shouldReturnInvalidProductQuantityErrorQuantityAboveLimit() {
        int quantity = MAX_LIMIT + 1;
        InvalidProductQuantityError error = assertThrows(
            InvalidProductQuantityError.class,
            () -> new ProductQuantityValidator(MAX_LIMIT).validate(quantity)
        );
        assertEquals(
            new InvalidProductQuantityError(quantity, MAX_LIMIT),
            error
        );
    }

}
