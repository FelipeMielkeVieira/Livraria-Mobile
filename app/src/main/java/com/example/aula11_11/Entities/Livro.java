package com.example.aula11_11.Entities;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Livro implements Serializable {

    private Integer id;
    private final String nome;
    private final String sinopse;
    private final String editora;
    private final String ano;
    private Drawable imagem;

    public Livro(Integer id, String nome, String sinopse, String editora, String ano, Drawable imagem) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.editora = editora;
        this.ano = ano;
        this.imagem = imagem;
    }

    public Livro(Integer id, String nome, String sinopse, String editora, String ano) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.editora = editora;
        this.ano = ano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getEditora() {
        return editora;
    }

    public String getAno() {
        return ano;
    }

    public Drawable getImagem() {
        return imagem;
    }
}
