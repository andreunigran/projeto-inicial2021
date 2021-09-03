package br.unigran.domain;

import android.graphics.Bitmap;
import android.text.Editable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Produto implements Serializable {
    private String nome;
    private Integer quantidade;
    private Double valor;
    private Integer id;
    private byte[] imagem;

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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

}
