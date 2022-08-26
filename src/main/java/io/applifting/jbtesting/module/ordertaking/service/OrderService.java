package io.applifting.jbtesting.module.ordertaking.service;

import io.applifting.jbtesting.module.ordertaking.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final CustomerInfoService cus = new CustomerInfoService();

    ValidatedOrder createOrder(String email, List<ValidatedOrderLine> orderLines) throws InvalidEmailError {
        CustomerInfo customer = cus.createCustomer(email);
        ValidatedOrder order = new ValidatedOrder(customer, orderLines);
        return order;
    }

}
