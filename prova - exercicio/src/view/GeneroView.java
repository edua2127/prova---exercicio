package view;

import Controller.GeneroController;
import Controller.LivroController;
import model.Genero;
import model.Livro;

import java.util.List;
import java.util.Scanner;

public class GeneroView {
    Scanner scanner = new Scanner(System.in);
    GeneroController generoController = new GeneroController();
    LivroController livroController = new LivroController();
    public void cadastrarGenero() {
        Genero genero = new Genero();
        System.out.print("digite o nome do genero: ");
        genero.setNome(scanner.nextLine());
        generoController.cadastrarGenero(genero);
    }

    public void editarGenero() {
        List<Genero> generos = generoController.listarGeneros();
        for (Genero genero : generos) {
            System.out.println("id_genero: " + genero.getIdGenero() + " nome do genero: " + genero.getNome());
        }
        System.out.println("---------------------------------");
        Genero tmp = new Genero();
        System.out.println("digite o id do genero a ser editado");
        tmp.setIdGenero(Long.parseLong(scanner.nextLine()));
        System.out.print("digite o novo nome: ");
        tmp.setNome(scanner.nextLine());
        generoController.editarGenero(tmp);
    }

    public void mostrarLivrosGenero() {
        List<Genero> generos = generoController.listarGeneros();
        for (int i = 0; i< generos.size(); i++) {
            System.out.println("posicao: " + i + " nome do genero: " + generos.get(i).getNome());
        }
        System.out.println("escolha o genero a partir da posicao: ");
        int posicao = Integer.parseInt(scanner.nextLine());
        List<Livro> livroGenero = livroController.livrosGenero(generos.get(posicao).getIdGenero());
        System.out.println("\n\n");
        for (Livro livro : livroGenero) {
            System.out.println("nome do livro: " + livro.getNome() + " genero do livro: " + livro.getGenero().getNome() + " biblioteca do livro: " + livro.getBiblioteca().getNome());
        }
    }
}
