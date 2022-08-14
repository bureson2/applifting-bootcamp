package io.applifting.jbtesting.module.ordertaking.domain;

import java.util.Objects;

public class CustomerInfo {
    private final Email email;

    public CustomerInfo(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerInfo that)) return false;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
