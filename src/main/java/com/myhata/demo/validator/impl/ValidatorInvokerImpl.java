package com.myhata.demo.validator.impl;

import com.myhata.demo.validator.ValidatorInvoker;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;


public class ValidatorInvokerImpl implements ValidatorInvoker {

    @Override
    public void validatorInvoker(Validator validator, Object target, String targetName, Object... validationHints) {
        BindingResult errors = new BeanPropertyBindingResult(target, targetName);
        ValidationUtils.invokeValidator(validator, target, errors, validationHints);

        if(errors.hasErrors()) {
            throw new IllegalArgumentException(errors.getAllErrors().toString());
        }
    }

    @Override
    public void validatorInvoker(Validator validator, Object target, String targetName) {
        validatorInvoker(validator, target, targetName, new ArrayList<>());
    }
}
