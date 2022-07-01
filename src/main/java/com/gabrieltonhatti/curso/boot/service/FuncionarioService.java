package com.gabrieltonhatti.curso.boot.service;

import com.gabrieltonhatti.curso.boot.domain.Cargo;
import com.gabrieltonhatti.curso.boot.domain.Funcionario;
import com.gabrieltonhatti.curso.boot.util.PaginacaoUtil;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioService {

    void salvar(Funcionario funcionario);

    void editar(Funcionario funcionario);

    void excluir(Long id);

    Funcionario buscarPorId(Long id);

    List<Funcionario> buscarTodos();

    List<Funcionario> buscarPorNome(String nome);

    List<Funcionario> buscarPorCargo(Long id);

    List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida);

    PaginacaoUtil<Funcionario> buscarPorPagina(int pagina, String direcao, String coluna);

}