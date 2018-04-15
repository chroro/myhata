package com.myhata.demo.task.service.impl;

import com.myhata.demo.entitites.common.Status;
import com.myhata.demo.entitites.task.Task;
import com.myhata.demo.entitites.user.UserTask;
import com.myhata.demo.period.service.PeriodService;
import com.myhata.demo.pojos.requests.TaskRequest;
import com.myhata.demo.pojos.requests.VoteRequest;
import com.myhata.demo.repository.RepositoryService;
import com.myhata.demo.scheduler.SchedulerService;
import com.myhata.demo.task.dao.TaskDao;
import com.myhata.demo.task.service.TaskService;
import com.myhata.demo.usertask.dao.UserTaskDao;
import com.myhata.demo.usertask.service.impl.UserTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private PeriodService periodService;

    @Autowired
    private UserTaskServiceImpl userTaskService;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private UserTaskDao userTaskDao;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private SchedulerService schedulerService;

    @Override
    @Transactional
    public boolean createTask(TaskRequest taskRequest) {
        //Resolve current user issue
        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setPeriod(periodService.buildPeriod(taskRequest));
        task.setRandom(taskRequest.isRandom());

        if(taskRequest.getIdPriorityPair().size() == 1) {
            task.setStatus(Status.ACTIVE);
            Long userId = taskRequest.getIdPriorityPair().keySet().iterator().next();
            userTaskService.createUserTask(task, userId, taskRequest.getStartDate(),Status.ACTIVE);
            return false;
        }
        else {
            task.setStatus(Status.PENDING);
            userTaskService.createUserTasks(taskRequest, task);
            schedulerService.scheduleTask(task.getId(), taskRequest.getStartDate().getTime());
            return true;
        }
    }

    @Transactional
    public boolean vote(VoteRequest voteRequest) {
        Task task = taskDao.getTaskById(voteRequest.getTaskId());
        Integer numberOfUsers = userTaskDao.countUserTasks(voteRequest.getTaskId());
        UserTask userTask = userTaskDao.getUserTaskByUserAndTaskId(voteRequest.getUserId(), voteRequest.getTaskId());

        if(voteRequest.isSupports()) {
            task.incrementSupport();
            userTask.setSupports(true);
        }
        else {
            task.incrementAgainst();
            userTask.setAgainst(true);
        }

        if(task.getSupports() > (Math.round(new Double(numberOfUsers) / new Double( 2)))) {
            task.setStatus(Status.ACTIVE);
            //TODO assign a responsible person
        }
        else if(task.getAgainst() > (Math.round(new Double(numberOfUsers) / new Double( 2)))) {
            task.setStatus(Status.REJECTED);
            userTaskDao.getUserTasksByTaskId(voteRequest.getTaskId()).forEach(u -> {
                u.setStatus(Status.ARCHIVED);
                repositoryService.update(u);
            });
        }
        repositoryService.update(task);
        return true;
    }


}
