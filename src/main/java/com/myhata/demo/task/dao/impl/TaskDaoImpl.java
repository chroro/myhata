package com.myhata.demo.task.dao.impl;

import com.myhata.demo.common.ErrorCodeConstants;
import com.myhata.demo.entitites.task.Task;
import com.myhata.demo.task.dao.TaskDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Task getTaskById(Long id) {
        List<Task> tasks = entityManager.createQuery("SELECT t FROM Task t WHERE t.id :=id").setParameter("id",id)
                            .getResultList();

        if(!tasks.isEmpty()) {
            return tasks.get(0);
        }

        throw new IllegalArgumentException(ErrorCodeConstants.TASK_WAS_NOT_FOUND);
    }
}
