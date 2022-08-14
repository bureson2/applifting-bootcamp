package io.applifting.jbtesting.module.ordertaking.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    void testShouldReturnNormalizedEmailAddress() throws InvalidEmailError {
        assertEquals(
            new Email("java-bootcamp@applifting.io"),
            new EmailValidator().validate("\njava-bootcamp@applifting.io ".toUpperCase())
        );
    }

    @Test
    void testShouldThrowAnErrorWithInvalidEmailAddress() {
        final var email = "@applifting.io ";
        InvalidEmailError error = assertThrows(
            InvalidEmailError.class,
            () -> new EmailValidator().validate(email)
        );
        assertEquals(new InvalidEmailError(email), error);
    }
}
