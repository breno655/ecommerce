package Entidades;

import java.util.*;

public class Vendedor extends Usuario {

    private Map<Integer, Produto> produtos;
    private List<Cliente> clientes;
    private float saldoVendedor;
    Random gerador = new Random();

    public Vendedor () {

    }

    public Vendedor (String nome, String login, String senha, int codigo) {
        super(nome, login, senha, codigo);
        this.produtos = new HashMap<>();
        this.codigo = 3;
    }


    public Produto criaProdutos(String nome, float preco, String descricao, int quantidade, Ecommerce ecommerce) {
        int codigoDeBarras = geraCodigo(ecommerce);
        if (codigoDeBarras != 0) {
            System.out.println("CODIGO DE BARRAS: " + codigoDeBarras);
            Produto novoProduto = new Produto(nome, preco, descricao, quantidade, codigoDeBarras);
            this.getProdutos().put(codigoDeBarras, novoProduto); // abaixo é adicionado os produtos na lista de produtos do vendedor pra saber que cada vendedor tem sua lista de produtos para vender.
            ecommerce.getTodosOsProdutosDoEcommerce().put(codigoDeBarras, novoProduto); // adicionar um novo produto na lista do ecommerce
            return novoProduto;
        } return new Produto();
    }

    public int geraCodigo (Ecommerce ecommerce) {
        int codigoDeBarras = gerador.nextInt(10000);
        if (!ecommerce.getTodosOsProdutosDoEcommerce().containsKey(codigoDeBarras) && !produtos.containsKey(codigoDeBarras)) {
            return codigoDeBarras;
        } return 0;
    }

    public void removerProdutos (Categoria categoria, String nomeProduto, Ecommerce ecommerce) {
        categoria.getProdutos().removeIf(produto -> produto.getNome().equals(nomeProduto));
        for (Produto produtoExcluido : ecommerce.getTodosOsProdutosDoEcommerce().values()) {
            // remover um produto na lista do ecommerce
            if (produtoExcluido.getNome().equals(nomeProduto)) {
                // usando a chave do Map (codigo de barras do produto) para remover o Produto
                Integer chave = produtoExcluido.getCodigoProduto();
                ecommerce.getTodosOsProdutosDoEcommerce().remove(chave);
            }
        }
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
        for (Produto produto : getProdutos().values()) {
            System.out.println("- " + produto.getNome());
        }
    }

    public void adicionaProdutosNaCategoria (Categoria categoria, List<Produto> produto) {
        categoria.getProdutos().addAll(produto);
    }

    public void adicionaProdutosNaSubcategoria (Categoria subcategoria, Produto produto) {
        subcategoria.getProdutos().add(produto);
    }



    public int getCodigoVendedor() {
        return 3;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Map<Integer, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<Integer, Produto> produtos) {
        this.produtos = produtos;
    }

    public float getSaldoVendedor() {
        return saldoVendedor;
    }

    public void setSaldoVendedor(float saldoVendedor) {
        this.saldoVendedor = saldoVendedor;
    }
}