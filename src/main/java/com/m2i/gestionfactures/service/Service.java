package com.m2i.gestionfactures.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

    Optional<T> get(Long id);

    List<T> getAll();

    T create(T t);

    void update(T t);

    void delete(Long id);

}
