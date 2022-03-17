package Entidades;

import java.util.*;

public class Vendedor extends Usuario {

    private String nome;
    private List<Produto> produtos;

    public Vendedor (String nome, String login, String senha) {
        super(nome, login, senha);
        this.produtos = new ArrayList<>();
    }

    public void adicionaProdutoEmCategoria(Map<Categoria, List<Produto>> dicionario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quer adicionar os produtos em que categoria? ");
        String qualCategoria = scanner.nextLine();

        System.out.print("Quantos produtos você deseja adicionar? ");
        int quantidadeDeProdutos = Integer.parseInt(scanner.nextLine());

        List<Produto> produtosNaCategoria = new ArrayList<>();

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

            produtosNaCategoria.add(new Produto(nome, preco, descricao, quantidade));
        }
        // abaixo vai ser armazenado os produtos do vendedor na lista
        this.produtos.addAll(produtosNaCategoria);

        // abaixo vai ser inserido a lista de produtos dentro da categoria
        for (Categoria key : dicionario.keySet()) {
            if (Objects.equals(key.getNome(), qualCategoria)){
                List<Produto> value = dicionario.get(key);
                if (value == null) {
                    dicionario.replace(key, null, produtosNaCategoria);
                    break;
                } else {
                    value.addAll(produtosNaCategoria);
                }
            }
        }

        int cont = 0;
        int cont1 = 0;
        for (Categoria keyCategoria : dicionario.keySet()) {
            ++cont;
            for (Categoria keySubcategoria : keyCategoria.getSubcategorias()) {
                ++cont1;
                System.out.println(cont + ". " + keyCategoria + "\n    "
                        + cont1 + ". " + keySubcategoria + "\n     " + dicionario.get(keyCategoria));
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
