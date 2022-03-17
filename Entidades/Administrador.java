package Entidades;

import java.util.*;

public class Administrador extends Usuario {

    Scanner scanner = new Scanner(System.in);

    public Administrador (String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public void criaCategoria(Map<Categoria, List<Produto>> dicionario) {
        for (int i = 0; i < 3; i++) {

            System.out.print("Nome da Categoria: ");
            String nomeCategoria = scanner.nextLine();

            Categoria categoria = new Categoria(nomeCategoria);
            dicionario.put(categoria, null);

        }
    }

    public void criaSubcategoria (Map<Categoria, List<Produto>> dicionario) {
        System.out.print("Quer adicionar as subcategorias em que categoria? ");
        String qualCategoria = scanner.nextLine();

        for (int i = 0; i < 2; i++) {

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

}
