package com.example.application.data.dao;

import com.example.application.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO extends GenericDAO {

    public static void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS filmes (
                IdFilme INTEGER PRIMARY KEY AUTOINCREMENT,
                NomeFilme VARCHAR(255),
                FaixaEtaria INT,
                DT_Lanc VARCHAR(255),
                Genero VARCHAR(255),
                MinutosDuracao INT,
                Quantidade INT,
                Preco FLOAT
            )
        """;

        try (Connection c = conn();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.executeUpdate();
            System.out.println("Tabela 'filmes' criada com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO ao criar tabela 'filmes'");
            e.printStackTrace();
        }
    }


    public void InserirFilme(Filme filme) {
        String sql = """
                insert into filmes( NomeFilme, FaixaEtaria, DT_Lanc, Genero, MinutosDuracao, Quantidade, Preco)
                values(?,?, ?, ?,?,?,?)
        """;
        try (Connection c = conn();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, filme.getNomeFilme());
            p.setInt(2, filme.getFaixaEtaria());
            p.setString(3, filme.getDT_Lanc());
            p.setString(4, filme.getGenero());
            p.setInt(5, filme.getMinutosDuracao());
            p.setInt(6, filme.getQuantidade());
            p.setDouble(7, filme.getPreco());

            p.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR FILME: " + filme);
            e.printStackTrace();
        }
    }
    public static List<Filme> SelectFilmes() {
        List<Filme> filmes = new ArrayList<>();

        String consultaSql = """
            select IdFilme, NomeFilme, FaixaEtaria, DT_Lanc, Genero, MinutosDuracao, Quantidade, Preco from filmes
            """;

        try (Connection c = conn();
             PreparedStatement p = c.prepareStatement(consultaSql)) {

            ResultSet resultSet = p.executeQuery();

            while (resultSet.next()) {
                Filme filmeSelect = new Filme(0,"",0,"","",0,0,0);

                filmeSelect.setIdFilme(resultSet.getInt("IdFilme"));
                filmeSelect.setNomeFilme(resultSet.getString("NomeFilme"));
                filmeSelect.setFaixaEtaria(resultSet.getInt("FaixaEtaria"));
                filmeSelect.setDT_Lanc(resultSet.getString("DT_Lanc"));
                filmeSelect.setGenero(resultSet.getString("Genero"));
                filmeSelect.setMinutosDuracao(resultSet.getInt("MinutosDuracao"));
                filmeSelect.setQuantidade(resultSet.getInt("Quantidade"));
                filmeSelect.setPreco(resultSet.getDouble("Preco"));

                filmes.add(filmeSelect);
            }

        } catch (SQLException e) {
            System.out.println("ERRO AO CONSULTAR OS FILMES ");
            e.printStackTrace();
        }
        return filmes;
    }

    public static void  DeleteFilmes(int idFilmeSelected){
        String deleteSql = """
            DELETE FROM filmes WHERE IdFilme = ?
                      """;

        try (Connection c = conn();
            PreparedStatement p = c.prepareStatement(deleteSql)) {
            p.setInt(1,idFilmeSelected);
            p.executeUpdate();



        } catch (SQLException e) {
            System.out.println("ERRO AO DELETAR OS FILMES ");
            e.printStackTrace();
        }


    }
    public static void  UpdateFilmes(Filme filme){
        String updateSql = """
                UPDATE filmes SET NomeFilme = ?, FaixaEtaria = ?, DT_Lanc = ?, Genero = ?, MinutosDuracao = ?, Quantidade = ?, Preco = ?
                         WHERE IdFilme = ?
                          """;

        try (Connection c = conn();
             PreparedStatement p = c.prepareStatement(updateSql)) {
            p.setString(1,filme.getNomeFilme());
            p.setInt(2,filme.getFaixaEtaria());
            p.setString(3,filme.getDT_Lanc());
            p.setString(4,filme.getGenero());
            p.setInt(5,filme.getMinutosDuracao());
            p.setInt(6,filme.getQuantidade());
            p.setDouble(7,filme.getPreco());
            p.setInt(8,filme.getIdFilme());
            p.executeUpdate();



        } catch (SQLException e) {
            System.out.println("ERRO AO EDITAR OS FILMES ");
            e.printStackTrace();
        }



    }}

