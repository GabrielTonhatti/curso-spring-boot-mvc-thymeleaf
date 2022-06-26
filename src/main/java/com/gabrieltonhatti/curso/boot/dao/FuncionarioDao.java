package com.gabrieltonhatti.curso.boot.dao;

import com.gabrieltonhatti.curso.boot.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {

    void save(Funcionario departamento);

    void update(Funcionario departamento);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();

}
