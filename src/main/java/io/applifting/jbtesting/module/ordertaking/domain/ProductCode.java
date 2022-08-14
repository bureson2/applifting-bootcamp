package io.applifting.jbtesting.module.ordertaking.domain;

public class ProductCode {
    private final String code;

    public ProductCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCode)) return false;
        return ((ProductCode) o).code.equals(this.code);
    }
}
