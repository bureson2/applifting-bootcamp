package io.applifting.jbtesting.module.ordertaking.domain;

public class InvalidEmailError extends Exception {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidEmailError error)) return false;
        return error.getMessage().equals(this.getMessage());
    }

    public InvalidEmailError(String email) {
        super("Given e-mail address '%s' is not valid".formatted(email));
    }
}
