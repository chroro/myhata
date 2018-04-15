package com.myhata.demo.common;

public class ErrorCodeConstants {

    public static final String NULL_TASK_NAME = "Task name can not be null";
    public static final String START_DATE_CAN_NOT_BE_NULL = "Start date can not be null";
    public static final String START_DATE_CAN_NOT_BE_LESS_THAN_CURRENT_TIME = "Start date can not earlier than current day";
    public static final String USER_DOESNT_EXIST = "User doesn't exist";
    public static final String AT_LEAST_ONE_USER_SHOULD_BE_RESONSIBLE_FOR_A_TASK = "At least one user should be responsible for a task";
    public static final String PERIOD_STEP_CAN_NOT_BE_NULL = "Period step can not be null or zero";
    public static final String TASK_WAS_NOT_FOUND ="Task was not found";
    public static final String INVALID_TASK ="Task is not pending";
    public static final String USER_IS_NOT_RELATED_TO_THIS_TASK ="User is not related to this task";
    public static final String QUERY_DID_NOT_GIVE_ANY_RESULTS = "No results";
}
