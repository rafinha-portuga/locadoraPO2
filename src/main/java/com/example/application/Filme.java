package com.example.application;

import org.springframework.data.domain.PageRequest;

import java.util.Arrays;

public class Filme {
    public int getIdFilme() {
        return IdFilme;
    }

    public void setIdFilme(int idFilme) {
        IdFilme = idFilme;
    }

    int IdFilme;
    String NomeFilme;
    int FaixaEtaria;
    String DT_Lanc;
    String Genero;
    int MinutosDuracao;
    int Quantidade;
    double Preco;

    @Override
    public String toString() {
        return "Filme{" +
                "IdFilme=" + IdFilme +
                ", NomeFilme='" + NomeFilme + '\'' +
                ", FaixaEtaria=" + FaixaEtaria +
                ", DT_Lanc='" + DT_Lanc + '\'' +
                ", Genero='" + Genero + '\'' +
                ", MinutosDuracao=" + MinutosDuracao +
                ", Quantidade=" + Quantidade +
                ", Preco=" + Preco +
                '}';
    }

    public Filme(int idFilme, String nomeFilme, int faixaEtaria, String DT_Lanc, String genero, int minutosDuracao, int quantidade, double preco) {
        IdFilme = idFilme;
        NomeFilme = nomeFilme;
        FaixaEtaria = faixaEtaria;
        this.DT_Lanc = DT_Lanc;
        Genero = genero;
        MinutosDuracao = minutosDuracao;
        Quantidade = quantidade;
        Preco = preco;
    }

    public String getNomeFilme() {
        return NomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        NomeFilme = nomeFilme;
    }

    public int getFaixaEtaria() {
        return FaixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        FaixaEtaria = faixaEtaria;
    }

    public String getDT_Lanc() {
        return DT_Lanc;
    }

    public void setDT_Lanc(String DT_Lanc) {
        this.DT_Lanc = DT_Lanc;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getMinutosDuracao() {
        return MinutosDuracao;
    }

    public void setMinutosDuracao(int minutosDuracao) {
        MinutosDuracao = minutosDuracao;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }



}