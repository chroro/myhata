package com.myhata.demo.task.conroller;

import com.myhata.demo.period.validator.PeriodValidator;
import com.myhata.demo.pojos.requests.TaskRequest;
import com.myhata.demo.pojos.requests.VoteRequest;
import com.myhata.demo.task.service.TaskService;
import com.myhata.demo.task.validators.TaskRequestValidator;
import com.myhata.demo.task.validators.VoteRequestValidator;
import com.myhata.demo.validator.ValidatorInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(path = "/task")
public class TaskController {

    @Autowired
    private TaskRequestValidator requestValidator;

    @Autowired
    private ValidatorInvoker validatorInvoker;

    @Autowired
    private PeriodValidator periodValidator;

    @Autowired
    private TaskService taskService;

    @Autowired
    private VoteRequestValidator voteRequestValidator;

    @RequestMapping(path = "/taskRequest", method = RequestMethod.POST)
    public ResponseEntity processTaskRequest(@RequestBody TaskRequest taskRequest) {
        validatorInvoker.validatorInvoker(requestValidator, taskRequest, "TaskRequest");
       if(taskService.createTask(taskRequest)) {
           return new ResponseEntity<>(HttpStatus.ACCEPTED);
       }
       else
           return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/voteRequest", method = RequestMethod.POST)
    public ResponseEntity voteRequest(@RequestBody VoteRequest voteRequest) {
        validatorInvoker.validatorInvoker(voteRequestValidator, voteRequest, "VoteRequest");

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
