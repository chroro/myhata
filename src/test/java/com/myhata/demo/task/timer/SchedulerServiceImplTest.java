package com.myhata.demo.task.timer;

import com.myhata.demo.scheduler.SchedulerServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerServiceImplTest {
    SchedulerServiceImpl schedulerServiceImpl = new SchedulerServiceImpl();
    ExecutorService executorService =
            Executors.newScheduledThreadPool(2);
    ScheduledExecutorService scheduledExecutorService =(ScheduledExecutorService) executorService;

    @Before
    public void prepare() {
        schedulerServiceImpl.getQueue().add(1l);
        schedulerServiceImpl.getQueue().add(2l);
    }

    @Test
    public void testTaskTimer() throws Exception{
        System.out.println("First \n");
        try {
            give();
        }
        catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("Second \n");
        Thread.sleep(10000);
    }

    private boolean give() {
        scheduledExecutorService.schedule(schedulerServiceImpl, 5, TimeUnit.SECONDS);
        return true;
    }

}
