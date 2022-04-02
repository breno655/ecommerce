package Entidades;

import java.util.*;

public class Vendedor extends Usuario {

    private String nome;
    final int codigoVendedor = 2;
    private List<Produto> produtos;

    Scanner scanner = new Scanner(System.in);

    public Vendedor () {

    }

    public Vendedor (String nome, String login, String senha) {
        super(nome, login, senha);
        this.produtos = new ArrayList<>();
    }

    public Produto criaProdutos(String nome, float preco, String descricao, int quantidade) {
        Produto novoProduto = new Produto(nome, preco, descricao, quantidade);
        // abaixo é adicionado os produtos na lista de produtos do vendedor pra saber que cada
        // vendedor tem sua lista de produtos para vender.
        this.produtos.add(novoProduto);
        return novoProduto;
    }

    public void listarProdutos (Map<Categoria, List<Categoria>> dicionario) {

    }

    public void removerProdutos (Categoria categoria, String nomeProduto) {
        categoria.getProdutos().removeIf(produto -> Objects.equals(produto.getNome(), nomeProduto));
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

   /* public void editarProdutos (Map<String, Categoria> dicionario) {
        System.out.println("Nome do produto a ser editado? ");
        String produtoAEditar = scanner.nextLine();

        System.out.println("Quer editar\n1- Nome\n2- Preço\n3- Descrição\n4- Quantidade");
        int opcaoEditar = Integer.parseInt(scanner.nextLine());

        for (Categoria key : dicionario.keySet()) {
            for (Categoria subcategorias : key.getSubcategorias()) {
                for (Produto produto: subcategorias.getProdutos()) {
                    if (produto.getNome().equals(produtoAEditar)) {
                        if (opcaoEditar == 1) {
                            System.out.print("Nome do novo produto: ");
                            String novoNome = scanner.nextLine();
                            produto.setNome(novoNome);
                        } else if (opcaoEditar == 2) {
                            System.out.print("Preço do novo produto: ");
                            float novoPreco = Float.parseFloat(scanner.nextLine());
                            produto.setPreco(novoPreco);
                        } else if (opcaoEditar == 3) {
                            System.out.print("Descrição do novo produto: ");
                            String novaDescricao = scanner.nextLine();
                            produto.setDescricao(novaDescricao);
                        } else if (opcaoEditar == 4) {
                            System.out.print("Quantidade do novo produto: ");
                            int novaQuantidade = Integer.parseInt(scanner.nextLine());
                            produto.setPreco(novaQuantidade);
                        }
                    }
                }
            }
        }
    }*/

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

}
