package com.exemplo.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    private String sku;
    private String nome;
    private String descricao;
    private double valor;
    private Integer entidade;

    public String getSky() {
        return sku;
    }

    public void setSky(String sky) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getEntidade() {
        return entidade;
    }

    public void setEntidade(Integer entidade) {
        this.entidade = entidade;
    }
}
