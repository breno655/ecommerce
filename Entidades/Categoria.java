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

    public Categoria () {

    }

    public Produto escolheProduto (String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nomeProduto)) {
                return produto;
            }
        } return null;
    }

    public void exibeProdutos () {
        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome());
        }
    }

    public void adicionaSubcategoria (Categoria subcategoria) {
        this.subcategorias.add(subcategoria);
    }

    public void exibeSubcategorias () {
        for (Categoria subcategoria : subcategorias) {
            System.out.println("- " + subcategoria.getNome().toUpperCase());
        }
    }

    public boolean possuiSubCats () {
        return !this.subcategorias.isEmpty();
    }

    public boolean removeCategoria (Categoria categoria) {
        for (Categoria cat : subcategorias) {
            if (cat.getNome().equals(categoria.getNome())) {
                subcategorias.remove(cat);
                return true;
            }
        } return false;
    }

    public boolean removeProduto (Produto produto) {
        for (Produto prod : produtos) {
            if (prod.getNome().equals(produto.getNome())) {
                produtos.remove(prod);
                return true;
            }
        } return false;
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
