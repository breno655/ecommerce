package Entidades;

import java.util.*;

public class Vendedor {

    private String nome;

    public Vendedor() {

    }

    public void adicionaProdutoEmCategoria(Map<Categoria, List<Produto>> dicionario) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos produtos você deseja adicionar? ");
        int quantidadeDeProdutos = Integer.parseInt(scanner.nextLine());

        List<Produto> produtos = new ArrayList<>();

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

        }
        // abaixo vai ser inserido a lista de produtos dentro da categoria
        //dicionario.replaceAll((k, v) -> produtos);

        System.out.print("Quer adicionar os produtos em que categoria? ");
        String qualCategoria = scanner.nextLine();

        for (Categoria key : dicionario.keySet()) {
            if (Objects.equals(key.getNome(), qualCategoria)){
                List<Produto> value = dicionario.get(key);
                if (value == null) {
                    dicionario.replace(key, null, produtos);
                    break;
                } else {
                    value.addAll(produtos);
                }
            }
        }


        int cont = 0;
        for (Categoria key : dicionario.keySet()) {
            ++cont;
            System.out.println(cont + ". " + key + "\n     " + dicionario.get(key));
        }

    }


}
