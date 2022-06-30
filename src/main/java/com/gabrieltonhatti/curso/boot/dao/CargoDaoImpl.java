package com.gabrieltonhatti.curso.boot.dao;

import com.gabrieltonhatti.curso.boot.domain.Cargo;
import com.gabrieltonhatti.curso.boot.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

    @Override
    public PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao) {
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;
        List<Cargo> cargos = getEntityManager()
                .createQuery("SELECT c FROM Cargo c ORDER BY c.nome " + direcao, Cargo.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, cargos);
    }

    public long count() {
        return getEntityManager()
                .createQuery("SELECT COUNT(c) FROM Cargo c", Long.class)
                .getSingleResult();
    }

}
