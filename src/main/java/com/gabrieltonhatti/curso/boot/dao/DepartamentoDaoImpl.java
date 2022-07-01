package com.gabrieltonhatti.curso.boot.dao;

import com.gabrieltonhatti.curso.boot.domain.Departamento;
import com.gabrieltonhatti.curso.boot.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {

    @Override
    public PaginacaoUtil<Departamento> buscaPaginada(int pagina, String direcao) {
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;

        List<Departamento> cargos = getEntityManager()
                .createQuery("SELECT d FROM Departamento d ORDER BY d.nome " + direcao.toUpperCase(), Departamento.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, cargos);
    }

    public long count() {
        return getEntityManager()
                .createQuery("SELECT COUNT(d) FROM Departamento d", Long.class)
                .getSingleResult();
    }
}