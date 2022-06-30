package com.gabrieltonhatti.curso.boot.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "enderecos")
public class Endereco extends AbstractEntity<Long> {

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String logradouro;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String bairro;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(nullable = false)
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 2)
    @NotNull(message = "{NotNull.endereco.uf}")
    private UF uf;

    @NotBlank
    @Column(nullable = false, length = 9)
    @Size(min = 9, max = 9, message = "{Size.endereco.cep}")
    private String cep;

    @Digits(integer = 5, fraction = 0)
    @Column(nullable = false, length = 5)
    @NotNull(message = "{NotNull.endereco.numero}")
    private Integer numero;

    @Size(max = 255)
    private String complemento;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
