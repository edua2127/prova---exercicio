package Controller;

import DAO.GeneroDAO;
import model.Genero;

import java.util.List;

public class GeneroController {
    GeneroDAO generoDAO = new GeneroDAO();
    public void cadastrarGenero(Genero genero) {
        generoDAO.cadastrarGenero(genero);
    }

    public void criarTabela() {
        generoDAO.criarTabela();
    }

    public List<Genero> listarGeneros() {
        return generoDAO.listarGeneros();
    }

    public void editarGenero(Genero genero){
        generoDAO.editarGenero(genero);
    }
}
