package io.applifting.jbtesting.module.ordertaking.service;

import io.applifting.jbtesting.module.ordertaking.domain.CustomerInfo;
import io.applifting.jbtesting.module.ordertaking.domain.Email;
import io.applifting.jbtesting.module.ordertaking.domain.EmailValidator;
import io.applifting.jbtesting.module.ordertaking.domain.InvalidEmailError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerInfoService {

    public CustomerInfo createCustomer(String email) throws InvalidEmailError {
        EmailValidator validator = new EmailValidator();
        Email correctEmail = validator.validate(email);
        return new CustomerInfo(correctEmail);
    }
}
