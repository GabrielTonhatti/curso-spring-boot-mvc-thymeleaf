package com.gabrieltonhatti.curso.boot.dao;

import com.gabrieltonhatti.curso.boot.domain.Cargo;
import com.gabrieltonhatti.curso.boot.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

    @Override
    public PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao, String coluna) {
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;

        String nomeColuna = coluna.equals("cargo") ? "c.nome" : "c.departamento.nome";

        String jpql = "SELECT c FROM Cargo c ORDER BY " + nomeColuna + " " + direcao.toUpperCase();
        List<Cargo> cargos = getEntityManager()
                .createQuery(jpql, Cargo.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, coluna, cargos);
    }

    public long count() {
        return getEntityManager()
                .createQuery("SELECT COUNT(c) FROM Cargo c", Long.class)
                .getSingleResult();
    }

}
