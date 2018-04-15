package com.myhata.demo.user.impl;

import com.myhata.demo.common.ErrorCodeConstants;
import com.myhata.demo.entitites.user.User;
import com.myhata.demo.user.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User getUserById(Long id) {
        List<User> userList =  entityManager.createQuery("SELECT u FROM User u WHERE u.id :=id")
                            .setParameter("id",id).getResultList();
        if(!userList.isEmpty()) {
            return userList.get(0);
        }

        throw new IllegalArgumentException(ErrorCodeConstants.USER_DOESNT_EXIST);
    }
}