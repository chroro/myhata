package com.myhata.demo.repository;

public interface RepositoryService {

    void save(Object object);

    Object update(Object object);

    void saveOrUpdate(Object object);
}
