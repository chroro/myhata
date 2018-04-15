package com.myhata.demo.period.service;


import com.myhata.demo.entitites.common.Period;
import com.myhata.demo.pojos.requests.TaskRequest;

public interface PeriodService {

    Period buildPeriod(TaskRequest taskRequest);
}
