package com.myhata.demo.scheduler;

import java.util.Date;

public interface SchedulerService {

    void scheduleTask(Long id, Date dueDate);
}
