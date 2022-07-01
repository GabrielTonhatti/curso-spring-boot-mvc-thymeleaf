package com.gabrieltonhatti.curso.boot.service;

import com.gabrieltonhatti.curso.boot.domain.Departamento;
import com.gabrieltonhatti.curso.boot.util.PaginacaoUtil;

import java.util.List;

public interface DepartamentoService {

    void salvar(Departamento departamento);

    void editar(Departamento departamento);

    void excluir(Long id);

    Departamento buscarPorId(Long id);

    List<Departamento> buscarTodos();

    boolean departamentoTemCargos(Long id);

    PaginacaoUtil<Departamento> buscarPorPagina(int paginaAtual, String ordem);
}
