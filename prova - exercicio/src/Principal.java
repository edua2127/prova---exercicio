import Controller.BibliotecaController;
import Controller.GeneroController;
import Controller.LivroController;
import model.Biblioteca;
import view.BibliotecaView;
import view.GeneroView;
import view.LivroView;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BibliotecaController bibliotecaController = new BibliotecaController();
        bibliotecaController.criarTabela();
        GeneroController generoController = new GeneroController();
        generoController.criarTabela();
        LivroController livroController = new LivroController();
        livroController.criarTabela();

        BibliotecaView bibliotecaView = new BibliotecaView();
        GeneroView generoView = new GeneroView();
        LivroView livroView = new LivroView();
        System.out.println("[1] CADASTRAR BIBLIOTECA");
        System.out.println("[2] CADASTRAR GÊNERO");
        System.out.println("[3] EDITAR GÊNERO");
        System.out.println("[4] CADASTRAR LIVRO");
        System.out.println("[5] ENCONTRAR LIVRO PELO SEU ID");
        System.out.println("[6] LISTAR TODOS OS LIVROS DE 1 BIBLIOTECA ESPECÍFICA");
        System.out.println("[7] LISTAR TODOS OS LIVROS DE DETERMINADO GÊNERO");
        System.out.print("escolha uma opcao: ");
        int escolha = Integer.parseInt(scanner.nextLine());
        switch (escolha) {
            case 1 -> bibliotecaView.cadastrarBiblioteca();
            case 2 -> generoView.cadastrarGenero();
            case 3 -> generoView.editarGenero();
            case 4 -> livroView.cadastrarLivro();
            case 5 -> livroView.escolherPeloId();
            case 6 -> bibliotecaView.mostrarLivrosDeUmaBiblioteca();
            case 7 -> generoView.mostrarLivrosGenero();
        }
    }
}
