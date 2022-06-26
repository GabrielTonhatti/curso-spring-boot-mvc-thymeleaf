package com.gabrieltonhatti.curso.boot.dao;

import com.gabrieltonhatti.curso.boot.domain.Cargo;

import java.util.List;

public interface CargoDao {

    void save(Cargo departamento);

    void update(Cargo departamento);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();

}
