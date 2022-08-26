package io.applifting.jbtesting.module.ordertaking.service;

import io.applifting.jbtesting.module.ordertaking.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineServiceTest {

    private final OrderLineService ols = new OrderLineService();

    @Test
    void shouldCreateProductCode() throws InvalidProductCodeError {
        String productCode = "W1234";
        ProductCodeValidator productCodeValidator = new ProductCodeValidator();
        ProductCode result = productCodeValidator.validate(productCode);
        assertEquals(
            new ProductCode(productCode),
            result
        );
    }

    @Test
    void shouldThrowInvalidProductCodeError() {
        String productCode = "Hamleys";
        ProductCodeValidator productCodeValidator = new ProductCodeValidator();

        final InvalidProductCodeError error = assertThrows(
            InvalidProductCodeError.class,
            () -> productCodeValidator.validate(productCode)
        );

        assertEquals(
            new InvalidProductCodeError(productCode),
            error
        );
    }

    @Test
    void shouldReturnProductQuantity() throws InvalidProductQuantityError {
        int quantity = 5;
        ProductQuantityValidator productQuantityValidator = new ProductQuantityValidator(10);
        ProductQuantity result = productQuantityValidator.validate(quantity);
        assertEquals(
            new ProductQuantity(5),
            result
        );
    }

    @Test
    void shouldThrowInvalidProductQuantityErrorBecauseMin() {
        int quantity = -5;
        int maxLimit = 10;
        ProductQuantityValidator productQuantityValidator = new ProductQuantityValidator(maxLimit);
        InvalidProductQuantityError error = assertThrows(
            InvalidProductQuantityError.class,
            () -> productQuantityValidator.validate(quantity)
        );
        assertEquals(
            new InvalidProductQuantityError(quantity, 10), error
        );
    }

    @Test
    void shouldThrowInvalidProductQuantityErrorBecauseMax() {
        int quantity = 50;
        int maxLimit = 10;
        ProductQuantityValidator productQuantityValidator = new ProductQuantityValidator(maxLimit);
        InvalidProductQuantityError error = assertThrows(
            InvalidProductQuantityError.class,
            () -> productQuantityValidator.validate(quantity)
        );
        assertEquals(
            new InvalidProductQuantityError(quantity, 10), error
        );
    }

    @Test
    void shouldCreateOrderLine() throws InvalidProductCodeError, InvalidProductQuantityError {
        String productCode = "W1234";
        int quantity = 5;
        int maxLimit = 10;

        ProductCodeValidator productCodeValidator = new ProductCodeValidator();
        ProductCode resultCode = productCodeValidator.validate(productCode);
        ProductQuantityValidator productQuantityValidator = new ProductQuantityValidator(maxLimit);
        ProductQuantity resultQuantity = productQuantityValidator.validate(quantity);

        ValidatedOrderLine result = ols.createOrderLine(productCode, quantity);

        assertEquals(
            new ValidatedOrderLine(resultCode, resultQuantity),
            result
        );

    }
}
