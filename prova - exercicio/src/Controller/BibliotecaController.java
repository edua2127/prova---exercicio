package Controller;

import DAO.BibliotecaDAO;
import model.Biblioteca;

import java.util.List;

public class BibliotecaController {
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        public void cadastrarBiblioteca(Biblioteca biblioteca){
                bibliotecaDAO.cadastrarBiblioteca(biblioteca);
        }

        public void criarTabela() {
                bibliotecaDAO.criaTabelaBiblioteca();
        }

        public List<Biblioteca> listar() {
                return bibliotecaDAO.listarBiblioteca();
        }
}
