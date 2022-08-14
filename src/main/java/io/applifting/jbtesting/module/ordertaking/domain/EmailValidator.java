package io.applifting.jbtesting.module.ordertaking.domain;

import java.util.Locale;
import java.util.regex.Pattern;

public class EmailValidator {
    private static final String EMAIL_REGEXP = "(?i)^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

    public Email validate(String unValidatedEmail) throws InvalidEmailError {
        String normalizedEmail = unValidatedEmail.trim().toLowerCase(Locale.ROOT);
        Pattern pattern = Pattern.compile(EMAIL_REGEXP);
        if (pattern.matcher(normalizedEmail).find()) {
            return new Email(normalizedEmail);
        } else {
            throw new InvalidEmailError(unValidatedEmail);
        }
    }
}
