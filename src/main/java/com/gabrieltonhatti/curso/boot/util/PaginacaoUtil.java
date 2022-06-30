package com.gabrieltonhatti.curso.boot.util;

import java.util.List;

public record PaginacaoUtil<T>(int tamanho, int pagina, long totalDePaginas, String direcao, String coluna,
                               List<T> registros) {

}
