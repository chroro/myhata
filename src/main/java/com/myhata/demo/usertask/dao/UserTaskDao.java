package com.myhata.demo.usertask.dao;

import com.myhata.demo.entitites.user.UserTask;

import java.util.List;

public interface UserTaskDao {
    List<UserTask> getUserTasksByTaskId(Long taskId);
    Integer countUserTasks(Long taskId);
    UserTask getUserTaskByUserAndTaskId(Long userId, Long taskId);
}
