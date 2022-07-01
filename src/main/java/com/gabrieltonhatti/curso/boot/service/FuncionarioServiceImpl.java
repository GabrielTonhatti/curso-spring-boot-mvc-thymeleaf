package com.gabrieltonhatti.curso.boot.service;

import com.gabrieltonhatti.curso.boot.dao.FuncionarioDao;
import com.gabrieltonhatti.curso.boot.domain.Funcionario;
import com.gabrieltonhatti.curso.boot.util.PaginacaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDao dao;

    @Override
    @Transactional(readOnly = false)
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    @Transactional(readOnly = false)
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }

    @Override
    @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        return dao.findByNome(nome);
    }

    @Override
    public List<Funcionario> buscarPorCargo(Long id) {
        return dao.findByCargoId(id);
    }

    @Override
    public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
        if (Objects.nonNull(entrada) && Objects.nonNull(saida)) {
            return dao.findByDataEntradaDataSaida(entrada, saida);
        } else if (Objects.nonNull(entrada)) {
            return dao.findByDataEntrada(entrada);
        } else if (Objects.nonNull(saida)) {
            return dao.findByDataSaida(saida);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public PaginacaoUtil<Funcionario> buscarPorPagina(int pagina, String direcao, String coluna) {
        return dao.buscaPaginada(pagina, direcao, coluna);
    }
}
