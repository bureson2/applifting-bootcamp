package io.applifting.jbtesting.module.ordertaking.service;

import io.applifting.jbtesting.module.ordertaking.domain.CustomerInfo;
import io.applifting.jbtesting.module.ordertaking.domain.Email;
import io.applifting.jbtesting.module.ordertaking.domain.EmailValidator;
import io.applifting.jbtesting.module.ordertaking.domain.InvalidEmailError;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerInfoServiceTest {
    private final CustomerInfoService cus = new CustomerInfoService();


    @Test
    void shouldReturnCustomerInfo() throws InvalidEmailError {
        String email = "ahoj@aaaa.cz";
        CustomerInfo original = new CustomerInfo(new Email("ahoj@aaaa.cz"));

        CustomerInfo customer = cus.createCustomer(email);

        assertEquals(
            original,
            customer
        );

    }

    @Test
    void shouldThrowInvalidEmailError(){
        String email = "ahoj@.cz";
        InvalidEmailError error = assertThrows(
            InvalidEmailError.class,
            () -> cus.createCustomer(email)
        );
        assertEquals(new InvalidEmailError(email), error);
    }

}
