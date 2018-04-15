package com.myhata.demo.pojos.requests;

import com.myhata.demo.entitites.common.Period;
import lombok.Data;

import java.util.Calendar;
import java.util.Map;


@Data
public class TaskRequest {
    private Map<Long, Integer> idPriorityPair;
    private String name;
    private String description;
    private Calendar startDate;
    private Integer step;
    private boolean periodic;
    private boolean random;
    private Period.Measurement measurement;
}
