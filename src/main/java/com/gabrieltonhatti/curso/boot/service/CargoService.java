package com.gabrieltonhatti.curso.boot.service;

import com.gabrieltonhatti.curso.boot.domain.Cargo;

import java.util.List;

public interface CargoService {

    void salvar(Cargo cargo);

    void editar(Cargo cargo);

    void excluir(Long id);

    Cargo buscarPorId(Long id);

    List<Cargo> buscarTodos();

    boolean cargoTemFuncionarios(Long id);
}
