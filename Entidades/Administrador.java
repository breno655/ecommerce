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

    public void criaCategoria(Map<String, Categoria> dicionario, String nomeNovaCategoria, int quantidadeCategoria) {
        for (int i = 0; i < quantidadeCategoria; i++) {
            Categoria novaCategoria = new Categoria(nomeNovaCategoria);
            dicionario.put(nomeNovaCategoria, novaCategoria);
        }
    }

    public void criaSubcategoria (Categoria categoria, String nomeSubcategoria) {
        if (categoria != null) {
            Categoria novaSubcategoria = new Categoria(nomeSubcategoria);
            categoria.adicionaSubcategoria(novaSubcategoria);
        } else {
            System.out.println("Não foi possível criar a Subcategoria");
        }
    }

    public void editarCategoria (String novoNomeDaCategoria, Categoria categoriaAEditar, Map<String, Categoria> dicionario) {
        dicionario.remove(categoriaAEditar.getNome());
        dicionario.put(novoNomeDaCategoria, categoriaAEditar);
        categoriaAEditar.setNome(novoNomeDaCategoria);
    }

    public void removerSubcategoria (Categoria subcategoriaARemover, Categoria subcategoriaEscolhida) {
        subcategoriaARemover.getSubcategorias().remove(subcategoriaEscolhida);
    }

    public void removerCategoria (Map<String, Categoria> dicionario) {
        System.out.print("Quantas categorias você quer REMOVER? ");
        int quantidadeRemoverCategoria = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantidadeRemoverCategoria; i++) {
            System.out.println("Nome da categoria a ser removida? ");
            String categoriaARemover = scanner.nextLine();

            //dicionario.keySet().removeIf(keySet -> Objects.equals(keySet.getNome(), categoriaARemover));

        }
    }

}
