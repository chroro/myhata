package com.myhata.demo.scheduler;

import com.myhata.demo.entitites.common.Status;
import com.myhata.demo.entitites.task.Task;
import com.myhata.demo.repository.RepositoryService;
import com.myhata.demo.task.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchedulerServiceImpl implements SchedulerService{

    @Autowired
    private TaskDao taskDao;

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Override
    public void scheduleTask(Long id, Date dueDate) {
        TaskVerifier taskVerifier = new TaskVerifier(id);
        threadPoolTaskScheduler.schedule(taskVerifier, dueDate);
    }


    class TaskVerifier implements Runnable {

        Long taskId;

        public TaskVerifier(Long taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            Task task = taskDao.getTaskById(taskId);
            if(!task.getStatus().equals(Status.ACTIVE)) {

            }
        }
    }
}
