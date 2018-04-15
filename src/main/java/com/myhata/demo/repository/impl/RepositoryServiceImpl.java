package com.myhata.demo.repository.impl;

import com.myhata.demo.repository.RepositoryService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class RepositoryServiceImpl implements RepositoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Object object) {
        entityManager.persist(object);
        entityManager.flush();
    }

    @Override
    public Object update(Object object){
        object = entityManager.merge(object);
        entityManager.flush();
        return object;
    }

    @Override
    public void saveOrUpdate(Object object) {
        
    }
}
