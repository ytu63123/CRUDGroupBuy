package com.lab.jpa.groupbuy.validation;

import com.lab.jpa.groupbuy.entities.Categories;
import com.lab.jpa.groupbuy.entities.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CategoriesValidation implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Categories.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Categories categories = (Categories) o;
        ValidationUtils.rejectIfEmpty(errors, "name", "categories.name.empty");

    }

}
