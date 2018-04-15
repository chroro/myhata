package com.myhata.demo.task.validators;

import com.myhata.demo.common.ErrorCodeConstants;
import com.myhata.demo.pojos.requests.TaskRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Service
public class TaskRequestValidator implements Validator {

    public boolean supports(Class clazz) {
        return TaskRequest.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        TaskRequest taskRequest = (TaskRequest) obj;

        if(taskRequest.getName().equals(null)) {
            errors.rejectValue("name", ErrorCodeConstants.NULL_TASK_NAME);
        }
    }
}
