package com.myhata.demo.usertask.service.impl;

import com.myhata.demo.entitites.common.Status;
import com.myhata.demo.entitites.task.Task;
import com.myhata.demo.entitites.user.UserTask;
import com.myhata.demo.pojos.requests.TaskRequest;
import com.myhata.demo.repository.RepositoryService;
import com.myhata.demo.user.UserDao;
import com.myhata.demo.usertask.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.*;

public class UserTaskServiceImpl implements UserTaskService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Random random;

    @Autowired
    private RepositoryService repositoryService;

    @Override
    @Transactional
    public void createUserTasks(TaskRequest taskRequest, Task task) {
        int numberOfUsers = taskRequest.getIdPriorityPair().size();
        List<Integer> priorities = new ArrayList<>();

        for(Map.Entry<Long, Integer> entry : taskRequest.getIdPriorityPair().entrySet()) {
            UserTask userTask = this.createUserTask(task,entry.getKey(), taskRequest.getStartDate(), Status.PENDING);

            if(taskRequest.isRandom()) {
                Integer integer = random.nextInt(numberOfUsers) + 1;
                while (!priorities.contains(integer)) {
                    integer = random.nextInt(numberOfUsers) + 1;
                }
                priorities.add(integer);
                userTask.setPriority(integer);
            }
            repositoryService.save(userTask);
        }
    }

    public UserTask createUserTask(Task task, Long userId, Calendar startDate, Status status) {
        UserTask userTask = new UserTask();
        userTask.setTask(task);
        userTask.setStartDate(startDate);
        userTask.setUser(userDao.getUserById(userId));
        userTask.setStatus(status);
        repositoryService.save(userTask);
        return userTask;
    }
}
