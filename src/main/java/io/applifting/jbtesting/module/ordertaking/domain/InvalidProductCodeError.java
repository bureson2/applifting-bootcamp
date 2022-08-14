package io.applifting.jbtesting.module.ordertaking.domain;

public class InvalidProductCodeError extends Exception {
    public InvalidProductCodeError(String code) {
        super("Given product code '%s' is not valid".formatted(code));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidProductCodeError error)) return false;
        return error.getMessage().equals(this.getMessage());
    }
}
