package com.gabrieltonhatti.curso.boot.dao;

import com.gabrieltonhatti.curso.boot.domain.Cargo;
import com.gabrieltonhatti.curso.boot.domain.Funcionario;
import com.gabrieltonhatti.curso.boot.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

    @Override
    public List<Funcionario> findByNome(String nome) {
        return createQuery("SELECT f FROM Funcionario f WHERE f.nome LIKE CONCAT('%', ?1, '%')", nome);
    }

    @Override
    public List<Funcionario> findByCargoId(Long id) {
        return createQuery("SELECT f FROM Funcionario f WHERE f.cargo.id = ?1", id);
    }

    @Override
    public List<Funcionario> findByDataEntrada(LocalDate entrada) {
        String jpql = "SELECT f FROM Funcionario f" +
                " WHERE f.dataEntrada = ?1" +
                " ORDER BY f.dataEntrada ASC";

        return createQuery(jpql, entrada);
    }

    @Override
    public List<Funcionario> findByDataSaida(LocalDate saida) {
        String jpql = "SELECT f FROM Funcionario f" +
                " WHERE f.dataSaida = ?1" +
                " ORDER BY f.dataEntrada ASC";

        return createQuery(jpql, saida);
    }

    @Override
    public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
        String jpql = "SELECT f FROM Funcionario f" +
                " WHERE f.dataEntrada >= ?1 AND f.dataSaida <= ?2" +
                " ORDER BY f.dataEntrada ASC";

        return createQuery(jpql, entrada, saida);
    }

    @Override
    public PaginacaoUtil<Funcionario> buscaPaginada(int pagina, String direcao, String coluna) {
        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;
        String nomeColuna = switch (coluna) {
            case "nome" -> "f.nome";
            case "salario" -> "f.salario";
            case "cargo" -> "f.cargo.nome";
            case "dataEntrada" -> "f.dataEntrada";
            case "dataSaida" -> "f.dataSaida";
            case "departamento" -> "f.cargo.departamento.nome";
            default -> "";
        };


        String jpql = "SELECT f FROM Funcionario f ORDER BY " + nomeColuna + " " + direcao.toUpperCase();
        List<Funcionario> cargos = getEntityManager()
                .createQuery(jpql, Funcionario.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, coluna, cargos);
    }

    public long count() {
        return getEntityManager()
                .createQuery("SELECT COUNT(f) FROM Funcionario f", Long.class)
                .getSingleResult();
    }
}
