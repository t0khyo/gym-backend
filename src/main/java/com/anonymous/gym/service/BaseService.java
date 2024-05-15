package com.anonymous.gym.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T,R> {

    List<T> getAll();

    T getById(UUID id);

    T create(R entity);

    T update(R entity);

    void delete(UUID id);
}

