package io.applifting.jbtesting.module.ordertaking.service;

import io.applifting.jbtesting.module.ordertaking.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {


    private final OrderService os = new OrderService();

    @Test
    void createOrderWith9OrderLines() throws InvalidProductCodeError, InvalidProductQuantityError, InvalidEmailError {
        String email = "ahoj@aaaa.cz";
        List<ValidatedOrderLine> orderLines = new ArrayList<>();
        ProductCodeValidator productCodeValidator = new ProductCodeValidator();
        ProductQuantityValidator productQuantityValidator = new ProductQuantityValidator(10);
        for(int i = 1; i < 10; i++){
            ProductCode code = productCodeValidator.validate("W000"+i);
            ProductQuantity quantity = productQuantityValidator.validate(i);
            orderLines.add(new ValidatedOrderLine(code , quantity));
        }
        ValidatedOrder result = os.createOrder(email, orderLines);

        CustomerInfo customer = new CustomerInfo(new Email(email));
        ValidatedOrder controlOrder = new ValidatedOrder(customer, orderLines);

        assertEquals(
            controlOrder,
            result
        );

    }

    @Test
    void createOrderWithoutOrderLines(){

    }

    //    @Test
//    void testShouldThrowAnErrorWithInvalidEmailAddress() {
//        final var email = "@applifting.io ";
//        InvalidEmailError error = assertThrows(
//            InvalidEmailError.class,
//            () -> new EmailValidator().validate(email)
//        );
//        assertEquals(new InvalidEmailError(email), error);
//    }
}
