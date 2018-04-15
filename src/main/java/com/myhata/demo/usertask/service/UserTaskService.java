package com.myhata.demo.usertask.service;

import com.myhata.demo.entitites.common.Status;
import com.myhata.demo.entitites.task.Task;
import com.myhata.demo.entitites.user.UserTask;
import com.myhata.demo.pojos.requests.TaskRequest;

import java.util.Calendar;

public interface UserTaskService {
    void createUserTasks(TaskRequest taskRequest, Task task);
    UserTask createUserTask(Task task, Long userId, Calendar startDate, Status status);
}
