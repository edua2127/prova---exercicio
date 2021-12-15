package Controller;

import DAO.LivroDAO;
import model.Livro;

import java.util.List;

public class LivroController {
    LivroDAO livroDAO = new LivroDAO();
    public void criarTabela() {
        livroDAO.criarTabela();
    }

    public void cadastrar(Livro livro) {
        livroDAO.cadastrarLivro(livro);
    }
    public Livro escolherPeloId(Long idLivro) {
        return livroDAO.selecionarPeloId(idLivro);
    }

    public List<Livro> livrosBibliotecas(Long idBiblioteca) {
        return livroDAO.selecionarPeloIdBiblioteca(idBiblioteca);
    }

    public List<Livro> livrosGenero(Long idGenero) {
        return livroDAO.livroGenero(idGenero);
    }


 }
