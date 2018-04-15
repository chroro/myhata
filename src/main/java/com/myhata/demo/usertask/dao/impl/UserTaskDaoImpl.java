package com.myhata.demo.usertask.dao.impl;

import com.myhata.demo.common.ErrorCodeConstants;
import com.myhata.demo.entitites.user.UserTask;
import com.myhata.demo.usertask.dao.UserTaskDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserTaskDaoImpl implements UserTaskDao{

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserTask> getUserTasksByTaskId(Long taskId) {
        return entityManager.createQuery(
                "SELECT uT FROM UserTask uT " +
                        "LEFT JOIN FETCH uT.task t "   +
                        "LEFT JOIN FETCH uT.user   "   +
                        "WHERE t.id :=taskId").setParameter("taskId",taskId).getResultList();
    }

    public Integer countUserTasks(Long taskId) {
        try {
            return (Integer) entityManager.createQuery(
                    "SELECT count(uT) FROM UserTask uT " +
                            "LEFT JOIN FETCH uT.task t " +
                            "WHERE t.id :=taskId").setParameter("taskId", taskId).getSingleResult();
        }
        catch (NonUniqueResultException e) {
            throw new IllegalArgumentException(ErrorCodeConstants.QUERY_DID_NOT_GIVE_ANY_RESULTS);
        }
    }

    public UserTask getUserTaskByUserAndTaskId(Long userId, Long taskId) {
        try {
            return (UserTask) entityManager.createQuery(
                    "SELECT uT FROM UserTask uT " +
                            "LEFT JOIN FETCH uT.task t " +
                            "LEFT JOIN FETCH uT.user u " +
                            "WHERE u.id :=userId AND " +
                            "t.id :=taskId").setParameter("userId", userId)
                    .setParameter("taskId", taskId).getResultList();
        }
        catch (NonUniqueResultException e) {
            throw new IllegalArgumentException(ErrorCodeConstants.QUERY_DID_NOT_GIVE_ANY_RESULTS);
        }
    }

}
