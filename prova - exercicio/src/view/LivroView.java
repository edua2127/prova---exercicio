package view;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Controller.LivroController;
import model.Biblioteca;
import model.Genero;
import model.Livro;

import java.util.List;
import java.util.Scanner;

public class LivroView {
    BibliotecaController bibliotecaController = new BibliotecaController();
    GeneroController generoController = new GeneroController();
    LivroController livroController = new LivroController();
    Scanner scanner = new Scanner(System.in);

    public void cadastrarLivro() {
        Livro livro = new Livro();
        List<Biblioteca> bibliotecas = bibliotecaController.listar();

        for (int i = 0; i < bibliotecas.size(); i++) {
            System.out.println("posicao: " + i + " nome da biblioteca: " + bibliotecas.get(i).getNome());
        }
        System.out.print("digite a posicao para escolher a biblioteca: ");
        livro.setBiblioteca(bibliotecas.get(Integer.parseInt(scanner.nextLine())));

        List<Genero> generos = generoController.listarGeneros();
        for (int i = 0; i < generos.size(); i++) {
            System.out.println("posicao: " + i + " nome do genero: " + generos.get(i).getNome());
        }
        System.out.println("digite a posicao para escolher o genero");
        livro.setGenero(generos.get(Integer.parseInt(scanner.nextLine())));

        System.out.print("digite o nome do livro: ");
        livro.setNome(scanner.nextLine());
        livroController.cadastrar(livro);
    }

    public void escolherPeloId() {
        System.out.print("digite o id do livro a ser escolhido: ");
        Livro livro = livroController.escolherPeloId(Long.parseLong(scanner.nextLine()));
        System.out.println("nome do livro: " + livro.getNome());
        System.out.println("genero do livro: " + livro.getGenero().getNome());
        System.out.println("biblioteca aonde se encontra esse livro: " + livro.getBiblioteca().getNome());
    }
}
