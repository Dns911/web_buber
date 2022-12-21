package com.epam.webproject.buber.dao;

import com.epam.webproject.buber.entity.AbstractEntity;

import java.util.List;

public abstract interface BaseDao<T extends AbstractEntity> {
    boolean insert(T t);
    boolean delete(T t);
    List<T> findAll();
    T update(T t);
}
