package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private String nome;
    private List<Categoria> subcategorias;

    public void adicionaSubcategoria (Categoria subcategoria) {
        this.subcategorias.add(subcategoria);
    }

    public Categoria (String nome) {
        this.nome = nome;
        this.subcategorias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString () {
        return String.format("%s\n", nome);
    }

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Categoria> subcategorias) {
        this.subcategorias = subcategorias;
    }
}
