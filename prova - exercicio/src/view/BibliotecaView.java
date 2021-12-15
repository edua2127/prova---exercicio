package view;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Controller.LivroController;
import model.Biblioteca;
import model.Genero;
import model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaView {
    Scanner scanner = new Scanner(System.in);
    BibliotecaController bibliotecaController = new BibliotecaController();
    LivroController livroController = new LivroController();
    GeneroController generoController = new GeneroController();
    public void cadastrarBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        System.out.print("digite o nome da biblioteca: ");
        biblioteca.setNome(scanner.nextLine());
        bibliotecaController.cadastrarBiblioteca(biblioteca);
    }

    public void mostrarLivrosDeUmaBiblioteca( ){
        List<Biblioteca> bibliotecaList = bibliotecaController.listar();

        for (int i = 0; i< bibliotecaList.size(); i++){
            System.out.println("posicao: " + i + " nome da biblioteca: " + bibliotecaList.get(i).getNome());
        }
        System.out.println("escolha a biblioteca a partir da posicao: ");

        List<Livro> livros = livroController.livrosBibliotecas(bibliotecaList.get(Integer.parseInt(scanner.nextLine())).getIdBiblioteca());
        for (Livro livro : livros) {
            System.out.println("nome do livro: " + livro.getNome() + " genero do livro: " + livro.getGenero().getNome() + " biblioteca do livro: " + livro.getBiblioteca().getNome());
        }
    }


}
