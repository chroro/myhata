package com.myhata.demo.validator;

import org.springframework.validation.Validator;

public interface ValidatorInvoker {

    void validatorInvoker(Validator validator, Object target, String targetName, Object... validationHints);

    void validatorInvoker(Validator validator, Object target, String targetName);

}
