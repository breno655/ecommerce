package Entidades;

import java.util.*;

public class Vendedor extends Usuario {

    private String nome;
    private List<Produto> produtos;

    Scanner scanner = new Scanner(System.in);

    public Vendedor () {

    }

    public Vendedor (String nome, String login, String senha) {
        super(nome, login, senha);
        this.produtos = new ArrayList<>();
    }

    public Produto criaProdutos(String nome, float preco, String descricao, int quantidade, Ecommerce ecommerce) {
        Produto novoProduto = new Produto(nome, preco, descricao, quantidade);
        this.produtos.add(novoProduto); // abaixo é adicionado os produtos na lista de produtos do vendedor pra saber que cada vendedor tem sua lista de produtos para vender.
        ecommerce.getTodosOsProdutosDoEcommerce().add(novoProduto); // adicionar um novo produto na lista do ecommerce
        return novoProduto;
    }

    public void removerProdutos (Categoria categoria, String nomeProduto, Ecommerce ecommerce) {
        categoria.getProdutos().removeIf(produto -> produto.getNome().equals(nomeProduto));
        ecommerce.getTodosOsProdutosDoEcommerce().removeIf(produto -> produto.getNome().equals(nomeProduto)); // nulo // remover um novo produto na lista do ecommerce
    }

    public void editarProdutos (int opcaoEditar, Produto produto, String novoNome, float novoPreco, String novaDescricao) {
        if (opcaoEditar == 1) {
            produto.setNome(novoNome);
        } else if (opcaoEditar == 2) {
            produto.setPreco(novoPreco);
        } else if (opcaoEditar == 3) {
            produto.setDescricao(novaDescricao);
        }
    }

    public void exibeProdutosVendedor () {
        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome());
        }
    }

    public void adicionaProdutosNaCategoria (Categoria categoria, List<Produto> produto) {
        categoria.getProdutos().addAll(produto);
    }

    public void adicionaProdutosNaSubcategoria (Categoria subcategoria, Produto produto) {
        subcategoria.getProdutos().add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getCodigoVendedor() {
        return 2;
    }
}
