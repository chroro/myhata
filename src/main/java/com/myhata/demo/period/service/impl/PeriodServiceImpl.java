package com.myhata.demo.period.service.impl;

import com.myhata.demo.entitites.common.Period;
import com.myhata.demo.period.service.PeriodService;
import com.myhata.demo.period.validator.PeriodValidator;
import com.myhata.demo.pojos.requests.TaskRequest;
import com.myhata.demo.repository.RepositoryService;
import com.myhata.demo.validator.ValidatorInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private PeriodValidator periodValidator;

    @Autowired
    private ValidatorInvoker validatorInvoker;

    @Override
    public Period buildPeriod(TaskRequest taskRequest) {
        Period period  = new Period();
        period.setStartDate(taskRequest.getStartDate());
        period.setPeriodic(taskRequest.isPeriodic());
        period.setStep(taskRequest.getStep());
        period.setMeasurement(taskRequest.getMeasurement());

        validatorInvoker.validatorInvoker(periodValidator, period, "period");

        repositoryService.save(period);
        return period;
    }
}
