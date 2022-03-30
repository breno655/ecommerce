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

    public void criaProdutos(Map<Categoria, List<Categoria>> dicionario, List<Produto> produtos) {

        System.out.print("Quantos produtos você deseja adicionar? ");
        int quantidadeDeProdutos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantidadeDeProdutos; i++) {
            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();
            System.out.print("Preço do produto: R$");
            float preco = Float.parseFloat(scanner.nextLine());
            System.out.print("Descrição do produto: ");
            String descricao = scanner.nextLine();
            System.out.print("Quantidade de produtos: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            System.out.println("");

            produtos.add(new Produto(nome, preco, descricao, quantidade));
            // abaixo é adicionado os produtos na lista de produtos do vendedor pra saber que cada
            // vendedor tem sua lista de produtos para vender.
            this.produtos.add(new Produto(nome, preco, descricao, quantidade));
        }
    }

    public void adicionaProdutosNaCategoria (Map<Categoria, List<Categoria>> dicionario, List<Produto> produtos) {
        System.out.print("Quer adicionar os produtos em qual CATEGORIA? ");
        String nomeDaCategoria = scanner.nextLine();

        for (Categoria key : dicionario.keySet()) {
            if (Objects.equals(key.getNome(), nomeDaCategoria)) {
                key.getProdutos().addAll(produtos);
                break;
            }
        }
    }

    public void adicionaProdutosNaSubcategoria (Map<Categoria, List<Categoria>> dicionario, List<Produto> produtos) {
        System.out.print("Quer adicionar os produtos em qual CATEGORIA? ");
        String nomeDaCategoria = scanner.nextLine();

        System.out.println("Quer adicionar os produtos em qual SUBCATEGORIA? ");
        String nomeDaSubcategoria = scanner.nextLine();

        for (Categoria key : dicionario.keySet()) {
            if (Objects.equals(key.getNome(), nomeDaCategoria)) {

                for (Categoria subcategorias : key.getSubcategorias()) {
                    if (Objects.equals(subcategorias.getNome(), nomeDaSubcategoria)) {
                        subcategorias.getProdutos().addAll(produtos);
                        break;
                    }
                }
                break;
            }
        }

    }

    public void removerProdutos (Map<Categoria, List<Categoria>> dicionario) {
        System.out.println("Quantos produtos você quer REMOVER");
        int quantidadeRemoverProdutos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantidadeRemoverProdutos; i++) {
            System.out.println("Nome do produto a ser removido? ");
            String produtoARemover = scanner.nextLine();

            for (Categoria key : dicionario.keySet()) {
                for (Categoria subcategorias : key.getSubcategorias()) {
                    subcategorias.getProdutos().removeIf(produto -> Objects.equals(produto.getNome(), produtoARemover));
                }
            }

        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
