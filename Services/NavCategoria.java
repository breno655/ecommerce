package Services;

import Entidades.Categoria;
import Entidades.Ecommerce;
import Entidades.Produto;

import java.util.Scanner;

public class NavCategoria {

    Scanner scanner = new Scanner(System.in);

    public Categoria navegaCategoria(Ecommerce ecommerce) {

        ecommerce.exibeCategorias();
        String nomeDaCategoria = escolheOpcao();
        Categoria categoriaEscolhida = ecommerce.escolheCategoria(nomeDaCategoria);
        while (categoriaEscolhida.possuiSubCats()) {
            categoriaEscolhida.exibeSubcategorias();
            nomeDaCategoria = escolheOpcao();
            try {
                categoriaEscolhida = ecommerce.escolheSubCat(nomeDaCategoria, categoriaEscolhida);
            } catch (NullPointerException e) {
                System.out.println("Mensagem: " + e.getMessage());
            }
        }
        return categoriaEscolhida;
    }

    public String escolheOpcao() {
        System.out.print("Opção: ");
        return scanner.nextLine();
    }

    public Produto detalheDoProduto(Categoria categoriaEscolhida){
        categoriaEscolhida.exibeProdutos();
        String nomeDoProduto = escolheOpcao();
        return categoriaEscolhida.escolheProduto(nomeDoProduto);
    }

}
