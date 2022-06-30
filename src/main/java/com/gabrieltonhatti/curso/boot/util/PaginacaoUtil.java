package com.gabrieltonhatti.curso.boot.util;

import java.util.List;

public class PaginacaoUtil<T> {

    private final int tamanho;
    private final int pagina;
    private final long totalDePaginas;
    private final List<T> registros;

    public PaginacaoUtil(int tamanho, int pagina, long totalDePaginas, List<T> registros) {
        this.tamanho = tamanho;
        this.pagina = pagina;
        this.totalDePaginas = totalDePaginas;
        this.registros = registros;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPagina() {
        return pagina;
    }

    public long getTotalDePaginas() {
        return totalDePaginas;
    }

    public List<T> getRegistros() {
        return registros;
    }
}
