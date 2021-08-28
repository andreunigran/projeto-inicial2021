package br.unigran.domain;

import android.text.Editable;

public class Produto {
    private String nome;
    private Integer quantidade;
    private Double valor;

    @Override
    public String toString() {
        return nome+" - " + quantidade ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
