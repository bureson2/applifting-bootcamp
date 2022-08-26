package io.applifting.jbtesting.module.ordertaking.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CustomerInfo {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "email_id")
    private Email email;

    public CustomerInfo() {

    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
