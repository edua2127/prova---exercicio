package DAO;

import Factory.Factory;
import model.Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {

    Connection connection;

    public BibliotecaDAO() {
        this.connection = new Factory().getConection();
    }

    public void criaTabelaBiblioteca(){
        String sql = "CREATE TABLE IF NOT EXISTS biblioteca("+
                "id_biblioteca bigint primary key auto_increment,"+
                "nome_biblioteca VARCHAR(45));";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarBiblioteca(Biblioteca biblioteca) {
        String sql = "INSERT INTO prova.biblioteca (nome_biblioteca) value (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,biblioteca.getNome());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Biblioteca> listarBiblioteca() {
        String sql = "select * from prova.biblioteca";
        List<Biblioteca> bibliotecas = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            Biblioteca biblioteca;
            while (resultSet.next()) {
                biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getLong("id_biblioteca"));
                biblioteca.setNome(resultSet.getString("nome_biblioteca"));
                bibliotecas.add(biblioteca);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bibliotecas;
    }

    public Biblioteca selecionarPorID(Long idBiblioteca) {
        String sql = "select * from prova.biblioteca where id_biblioteca = ?";
        Biblioteca biblioteca = new Biblioteca();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idBiblioteca);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                biblioteca.setIdBiblioteca(resultSet.getLong("id_biblioteca"));
                biblioteca.setNome(resultSet.getString("nome_biblioteca"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return biblioteca;
    }
}
