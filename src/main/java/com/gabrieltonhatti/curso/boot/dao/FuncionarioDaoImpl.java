package com.gabrieltonhatti.curso.boot.dao;

import com.gabrieltonhatti.curso.boot.domain.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
