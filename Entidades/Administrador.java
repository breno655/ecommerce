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

    public void removerSubcategoria (Map<Categoria, List<Categoria>> dicionario) {
        System.out.println("Quantas subcategorias você quer REMOVER");
        int quantidadeRemoverProdutos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantidadeRemoverProdutos; i++) {
            System.out.println("Nome da subcategoria a ser removida? ");
            String produtoARemover = scanner.nextLine();
            // fazer alteração abaixo para remover as subcategorias
            for (Categoria key : dicionario.keySet()) {
                for (Categoria subcategorias : key.getSubcategorias()) {
                    subcategorias.getProdutos().removeIf(produto -> Objects.equals(produto.getNome(), produtoARemover));
                }
            }

        }
    }

}
