package io.applifting.jbtesting.module.ordertaking.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ValidatedOrderLine {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_code_id")
    private ProductCode productCode;
    @OneToOne
    @JoinColumn(name = "product_quantity_id")
    private ProductQuantity productQuantity;

    public void setProductQuantity(ProductQuantity productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductCode(ProductCode productCode) {
        this.productCode = productCode;
    }

    public ValidatedOrderLine() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ValidatedOrderLine(ProductCode productCode, ProductQuantity productQuantity) {
        this.productCode = productCode;
        this.productQuantity = productQuantity;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public ProductQuantity getProductQuantity() {
        return productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidatedOrderLine that)) return false;
        return Objects.equals(productCode, that.productCode) && Objects.equals(productQuantity, that.productQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productQuantity);
    }
}
