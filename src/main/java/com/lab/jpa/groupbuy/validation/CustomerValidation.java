package com.lab.jpa.groupbuy.validation;

import com.lab.jpa.groupbuy.entities.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidation implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Customer.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;
        ValidationUtils.rejectIfEmpty(errors, "name", "customer.name.empty");

    }

}
