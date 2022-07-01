package com.gabrieltonhatti.curso.boot.dao;

import com.gabrieltonhatti.curso.boot.domain.Departamento;
import com.gabrieltonhatti.curso.boot.util.PaginacaoUtil;

import java.util.List;

public interface DepartamentoDao {

    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();

    PaginacaoUtil<Departamento> buscaPaginada(int paginaAtual, String ordem);
}
