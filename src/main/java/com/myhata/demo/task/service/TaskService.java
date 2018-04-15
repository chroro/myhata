package com.myhata.demo.task.service;

import com.myhata.demo.pojos.requests.TaskRequest;
import com.myhata.demo.pojos.requests.VoteRequest;

public interface TaskService {
    boolean createTask(TaskRequest taskRequest);
    boolean vote(VoteRequest voteRequest);
}
