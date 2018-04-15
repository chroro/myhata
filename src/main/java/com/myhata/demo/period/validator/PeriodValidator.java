package com.myhata.demo.period.validator;

import com.myhata.demo.common.ErrorCodeConstants;
import com.myhata.demo.entitites.common.Period;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PeriodValidator implements Validator {

    public boolean supports(Class clazz) {
        return Period.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        Period period = (Period) obj;

        // TODO System time should be dependent on timezone
        if(System.currentTimeMillis() < period.getStartDate().getTime().getTime()) {
            errors.rejectValue("startDate", ErrorCodeConstants.START_DATE_CAN_NOT_BE_LESS_THAN_CURRENT_TIME);
        }
        else if(period.getPeriodic() && period.getStep() == null || period.getStep().compareTo(new Integer(0)) == 0) {
            errors.rejectValue("step",ErrorCodeConstants.PERIOD_STEP_CAN_NOT_BE_NULL);
        }
    }
}
