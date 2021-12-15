package DAO;

import Factory.Factory;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    Connection connection;

    public LivroDAO() {
        this.connection = new Factory().getConection();
    }

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS prova.livros(" +
                "id_livro bigint primary key auto_increment, " +
                "id_biblioteca bigint, " +
                "foreign key(id_biblioteca) references biblioteca(id_biblioteca)," +
                "id_genero bigint, " +
                "foreign key(id_genero) references generos(id_genero)," +
                "nome_livro VARCHAR(45));";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarLivro(Livro livro) {
        String sql = "INSERT INTO prova.livros (id_biblioteca, id_genero, nome_livro) value (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, livro.getBiblioteca().getIdBiblioteca());
            statement.setLong(2, livro.getGenero().getIdGenero());
            statement.setString(3, livro.getNome());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro selecionarPeloId(Long idLivro) {
        String sql = "select * from prova.livros where id_livro = ?";
        Livro livro = new Livro();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idLivro);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                livro.setIdLivro(resultSet.getLong(1));
                GeneroDAO generoDAO = new GeneroDAO();
                livro.setGenero(generoDAO.selecionarporID(resultSet.getLong(3)));

                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                livro.setBiblioteca(bibliotecaDAO.selecionarPorID(resultSet.getLong("id_biblioteca")));

                livro.setNome(resultSet.getString(4));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return livro;
    }

    public List<Livro> selecionarPeloIdBiblioteca(Long idBiblioteca) {
        String sql = "select * from prova.livros where id_biblioteca = ?";
        List<Livro> meuslivros = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idBiblioteca);
            ResultSet resultSet = statement.executeQuery();
            Livro livro;
            while (resultSet.next()) {
                livro = new Livro();
                livro.setIdLivro(resultSet.getLong(1));
                GeneroDAO generoDAO = new GeneroDAO();
                livro.setGenero(generoDAO.selecionarporID(resultSet.getLong(3)));

                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                livro.setBiblioteca(bibliotecaDAO.selecionarPorID(resultSet.getLong("id_biblioteca")));

                livro.setNome(resultSet.getString(4));
                meuslivros.add(livro);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return meuslivros;
    }

    public List<Livro> livroGenero(Long idGenero) {
        String sql = "select * from prova.livros where id_genero = ?";
        List<Livro> meuslivros = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, idGenero);
            ResultSet resultSet = statement.executeQuery();
            Livro livro;
            while (resultSet.next()) {
                livro = new Livro();
                livro.setIdLivro(resultSet.getLong(1));
                GeneroDAO generoDAO = new GeneroDAO();
                livro.setGenero(generoDAO.selecionarporID(resultSet.getLong(3)));

                BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
                livro.setBiblioteca(bibliotecaDAO.selecionarPorID(resultSet.getLong("id_biblioteca")));

                livro.setNome(resultSet.getString(4));
                meuslivros.add(livro);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return meuslivros;
    }
}
