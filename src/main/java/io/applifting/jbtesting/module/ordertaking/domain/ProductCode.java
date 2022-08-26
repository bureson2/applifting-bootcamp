package io.applifting.jbtesting.module.ordertaking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductCode {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;

    public ProductCode() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
