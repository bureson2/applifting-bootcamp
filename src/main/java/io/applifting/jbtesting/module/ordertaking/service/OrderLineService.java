package io.applifting.jbtesting.module.ordertaking.service;

import io.applifting.jbtesting.module.ordertaking.domain.*;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {

    private int maxLimit = 10;

    ValidatedOrderLine createOrderLine(String code, int quantity) throws InvalidProductCodeError, InvalidProductQuantityError {
        ProductCodeValidator productCodeValidator = new ProductCodeValidator();
        ProductQuantityValidator productQuantityValidator = new ProductQuantityValidator(maxLimit);
        ProductCode resultCode = productCodeValidator.validate(code);
        ProductQuantity resultQuantity = productQuantityValidator.validate(quantity);
        ValidatedOrderLine orderLine = new ValidatedOrderLine(resultCode, resultQuantity);
        return orderLine;

    }

}
