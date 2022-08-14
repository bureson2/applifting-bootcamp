package io.applifting.jbtesting.module.ordertaking.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCodeValidatorTest {
    @Test
    void shouldReturnWProductCode() throws InvalidProductCodeError {
        assertEquals(
            new ProductCode("W1234"),
            new ProductCodeValidator().validate("w1234")
        );
    }

    @Test
    void shouldReturnGProductCode() throws InvalidProductCodeError {
        assertEquals(
            new ProductCode("G123"),
            new ProductCodeValidator().validate("g123")
        );
    }

    @Test
    void shouldThrowsInvalidProductCodeError() {
        String code = "a123";
        InvalidProductCodeError error = assertThrows(
            InvalidProductCodeError.class,
            () -> new ProductCodeValidator().validate(code)
        );
        assertEquals(
            new InvalidProductCodeError(code),
            error
        );
    }
}
