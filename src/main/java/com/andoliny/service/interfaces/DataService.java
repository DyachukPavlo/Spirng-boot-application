package com.andoliny.service.interfaces;

import com.andoliny.model.interfaces.DomainObject;

import java.util.List;

public interface DataService<T extends DomainObject> {
    public T save(T object);
    public void delete(T object);
    public List<T> getAll();
    T findOne(int id);
    void deleteAll();
}
