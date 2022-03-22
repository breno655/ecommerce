package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private String nome;
    private List<Categoria> subcategorias;
    private List<Produto> produtos;

    public Categoria (String nome) {
        this.nome = nome;
        this.subcategorias = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public void adicionaSubcategoria (Categoria subcategoria) {
        this.subcategorias.add(subcategoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Categoria> subcategorias) {
        this.subcategorias = subcategorias;
    }
}
