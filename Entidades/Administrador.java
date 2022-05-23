package Entidades;

import java.util.*;

public class Administrador extends Usuario {

    Scanner scanner = new Scanner(System.in);

    public Administrador () {

    }

    public Administrador (String nome, String login, String senha, int codigo) {
        super(nome, login, senha, codigo);
        this.login = "admin";
        this.senha = "admin";
        this.codigo = 2;
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

}