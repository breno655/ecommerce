package Entidades;

import java.util.*;

public class Ecommerce {

    public String nome = "Cyber Feira";
    private Map<Categoria, List<Categoria>> dicionario;
    private List<Produto> produtos;
    private List<Usuario> usuarios;

    public Ecommerce () {
        this.nome = nome;
        this.dicionario = new HashMap<>();
        this.produtos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void imprimirDicionario () {
        int contadorCategoria = 0;
        int contadorSubcategoria = 0;
        int contadorProduto = 0;

        for (Categoria key : dicionario.keySet()) {
            System.out.println(++contadorCategoria + ". " + key.getNome());
            for (Categoria subcategorias : key.getSubcategorias()) {
                System.out.println("   " + ++contadorSubcategoria + ". " + subcategorias.getNome());
                for (Produto produto : subcategorias.getProdutos()) {
                    System.out.println("     " + ++contadorProduto + ". " + produto.getNome());
                }
            }
        }
    }

    public Map<Categoria, List<Categoria>> getDicionario() {
        return dicionario;
    }

    public void setDicionario(Map<Categoria, List<Categoria>> dicionario) {
        this.dicionario = dicionario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
