package Entidades;

import java.util.*;

public class Administrador extends Usuario {

    Scanner scanner = new Scanner(System.in);

    final int codigoAdministrador = 0;

    public Administrador () {

    }

    public Administrador (String nome, String login, String senha) {
        super(nome, login, senha);
        this.login = "admin";
        this.senha = "admin";
    }

    public void criaCategoria(Map<Categoria, List<Categoria>> dicionario) {
        System.out.print("Deseja adicionar quantas? ");
        int quantidadeCategoria = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantidadeCategoria; i++) {

            System.out.print("Nome da Categoria: ");
            String nomeCategoria = scanner.nextLine();

            Categoria categoria = new Categoria(nomeCategoria);
            dicionario.put(categoria, null);

        }
    }

    public void criaSubcategoria (Map<Categoria, List<Categoria>> dicionario) {
        System.out.print("Quer adicionar as subcategorias em que categoria? ");
        String qualCategoria = scanner.nextLine();

        System.out.print("Deseja adicionar quantas? ");
        int quantidadeSubcategoria = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantidadeSubcategoria; i++) {
            System.out.print("Nome da Subcategoria: ");
            String nomeSubcategoria = scanner.nextLine();

            for (Categoria key : dicionario.keySet()) {
                if (Objects.equals(key.getNome(), qualCategoria)) {
                    key.adicionaSubcategoria(new Categoria(nomeSubcategoria));
                    break;
                }
            }
        }
    }

    public void editarCategoria (Map<Categoria, List<Categoria>> dicionario) {
        System.out.println("Nome da categoria a ser editada? ");
        String produtoAEditar = scanner.nextLine();

        System.out.println("Quer editar\n1- Nome");
        int opcaoEditar = Integer.parseInt(scanner.nextLine());

        for (Categoria key : dicionario.keySet()) {
            if (key.getNome().equals(produtoAEditar)) {
                if (opcaoEditar == 1) {
                    System.out.print("Nome da nova categoria: ");
                    String novoNome = scanner.nextLine();
                    key.setNome(novoNome);
                }
            }
        }
    }

    public void removerSubcategoria (Map<Categoria, List<Categoria>> dicionario) {
        System.out.print("Quantas subcategorias você quer REMOVER? ");
        int quantidadeRemoverSubcategoria = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantidadeRemoverSubcategoria; i++) {
            System.out.println("Nome da subcategoria a ser removida? ");
            String subcategoriaARemover = scanner.nextLine();

            for (Categoria key : dicionario.keySet()) {
                key.getSubcategorias().removeIf(subcategorias -> Objects.equals(subcategorias.getNome(), subcategoriaARemover));
            }

        }
    }

    public void removerCategoria (Map<Categoria, List<Categoria>> dicionario) {
        System.out.print("Quantas categorias você quer REMOVER? ");
        int quantidadeRemoverCategoria = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantidadeRemoverCategoria; i++) {
            System.out.println("Nome da categoria a ser removida? ");
            String categoriaARemover = scanner.nextLine();

            dicionario.keySet().removeIf(keySet -> Objects.equals(keySet.getNome(), categoriaARemover));

        }
    }

}
