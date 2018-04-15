package com.myhata.demo.task.validators;

import com.myhata.demo.common.ErrorCodeConstants;
import com.myhata.demo.entitites.common.Status;
import com.myhata.demo.entitites.task.Task;
import com.myhata.demo.entitites.user.UserTask;
import com.myhata.demo.pojos.requests.VoteRequest;
import com.myhata.demo.task.dao.TaskDao;
import com.myhata.demo.usertask.dao.UserTaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class VoteRequestValidator implements Validator {

    @Autowired
    private UserTaskDao userTaskDao;

    @Autowired
    private TaskDao taskDao;

    public boolean supports(Class clazz) {
        return VoteRequest.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        VoteRequest voteRequest = (VoteRequest) obj;
        Task task = taskDao.getTaskById(voteRequest.getTaskId());
        List<UserTask> userTasks = userTaskDao.getUserTasksByTaskId(voteRequest.getTaskId());

        if(!task.getStatus().equals(Status.PENDING)) {
            errors.rejectValue("task", ErrorCodeConstants.INVALID_TASK);
        }

        UserTask userTask = userTasks.stream().filter(uT -> uT.getUser().getId().equals(voteRequest.getUserId())).findFirst().orElse(null);

        if(userTask == null) {
            errors.rejectValue("userTask", ErrorCodeConstants.USER_IS_NOT_RELATED_TO_THIS_TASK);
        }
    }
}
