package DAO;

import Factory.Factory;
import model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {
    Connection connection;
    public GeneroDAO() {
        this.connection = new Factory().getConection();
    }

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS generos("+
                "id_genero bigint primary key auto_increment,"+
                "nome_genero VARCHAR(45));";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarGenero(Genero genero) {
        String sql = "INSERT INTO prova.generos (nome_genero) value (?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,genero.getNome());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Genero> listarGeneros() {
        String sql = "select * from prova.generos";
        List<Genero> generos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Genero genero;
            while (resultSet.next()) {
                genero = new Genero();
                genero.setIdGenero(resultSet.getLong("id_genero"));
                genero.setNome(resultSet.getString("nome_genero"));
                generos.add(genero);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return generos;
    }

    public Genero selecionarporID(Long idGenero) {
        String sql = "select * from prova.generos where id_genero = ?";
        Genero genero = new Genero();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idGenero);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                genero = new Genero();
                genero.setIdGenero(resultSet.getLong("id_genero"));
                genero.setNome(resultSet.getString("nome_genero"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genero;
    }
    public void editarGenero(Genero genero) {
        String sql = "UPDATE prova.generos set nome_genero = ? where id_genero = ?;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, genero.getNome());
            statement.setLong(2,genero.getIdGenero());
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
