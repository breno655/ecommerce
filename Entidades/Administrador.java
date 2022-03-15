package Entidades;

import java.util.*;

public class Administrador {

    private String nome;

    Scanner scanner = new Scanner(System.in);

    public Administrador(){

    }

    public void criaCategoria(Map<Categoria, List<Produto>> dicionario) {
        for (int i = 0; i < 3; i++) {

            System.out.print("Nome da categoria? ");
            String nomeCategoria = scanner.nextLine();

            Categoria categoria = new Categoria(nomeCategoria);
            dicionario.put(categoria, null);

        }
    }

    public void criaSubcategoria () {
        for (int i = 0; i < 3; i++) {

            System.out.print("Nome da categoria? ");
            String nomeCategoria = scanner.nextLine();

            Categoria categoria = new Categoria(nomeCategoria);


        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
