package io.applifting.jbtesting.module.ordertaking.domain;

import java.util.regex.Pattern;

public class ProductCodeValidator {
    private static final String W_REGEXP = "^W\\d\\d\\d\\d$";
    private static final String G_REGEXP = "^G\\d\\d\\d$";
    private final Pattern wPattern;
    private final Pattern gPattern;

    public ProductCodeValidator() {
        wPattern = Pattern.compile(W_REGEXP);
        gPattern = Pattern.compile(G_REGEXP);
    }

    public ProductCode validate(String code) throws InvalidProductCodeError {
        String upperCode = code.toUpperCase();
        if (upperCode.startsWith("W") && wPattern.matcher(upperCode).find()) {
            return new ProductCode(upperCode);
        } else if (upperCode.startsWith("G") && gPattern.matcher(upperCode).find()) {
            return new ProductCode(upperCode);
        } else {
            throw new InvalidProductCodeError(code);
        }
    }
}
