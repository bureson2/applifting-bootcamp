package io.applifting.jbtesting.module.ordertaking.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.List;

@Entity
public class ValidatedOrder {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_info_id")
    private CustomerInfo customerInfo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ValidatedOrderLine> orderLines;

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public ValidatedOrder() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ValidatedOrder(CustomerInfo customerInfo, List<ValidatedOrderLine> orderLines) {
        this.customerInfo = customerInfo;
        this.orderLines = orderLines;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public Collection<ValidatedOrderLine> getOrderLines() {
        return orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidatedOrder that)) return false;
        return Objects.equals(customerInfo, that.customerInfo) && Objects.equals(orderLines, that.orderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerInfo, orderLines);
    }
}
