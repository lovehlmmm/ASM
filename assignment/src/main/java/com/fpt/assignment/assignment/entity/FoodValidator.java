package com.fpt.assignment.assignment.entity;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FoodValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Food.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Food st = (Food) o;
        if (st.getFoodname().equals("admin")) {
            errors.rejectValue("fname", null, "Không thể đăng ký.");
        }
    }
}
