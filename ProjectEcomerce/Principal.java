package ProjectEcomerce;

import Entidades.Administrador;
import Entidades.Ecommerce;
import Entidades.Produto;
import Entidades.Vendedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Ecommerce ecommerce = new Ecommerce();
        Vendedor vendedor = new Vendedor(null, null, null);
        Administrador administrador = new Administrador(null, null, null);

        Scanner scanner = new Scanner(System.in);

        int tipoDeUsuario;
        do {
            System.out.println("1- Cliente\n2- Administrador\n3- Vendedor\n4- Sair");
            tipoDeUsuario = Integer.parseInt(scanner.nextLine());

            switch (tipoDeUsuario) {
                case 1:
                    break;

                case 2:
                    System.out.println("- Manipulando Categorias e Subcategorias -\n1- CRIAR" +
                            "\n2- LISTAR\n3- REMOVER\n4- EDITAR");
                    int opcaoCrudCategoria = Integer.parseInt(scanner.nextLine());

                    if (opcaoCrudCategoria == 1) {
                        System.out.println("1- Categoria\n2- Subcategoria");
                        int categoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                        if (categoriaOuSubcategoria == 1) {
                            administrador.criaCategoria(ecommerce.getDicionario());
                        }
                        if (categoriaOuSubcategoria == 2) {
                            administrador.criaSubcategoria(ecommerce.getDicionario());
                        }
                    }
                    if (opcaoCrudCategoria == 3) {
                        System.out.println("1- Categoria\n2- Subcategoria");
                        int categoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                        if (categoriaOuSubcategoria == 1) {
                            administrador.criaCategoria(ecommerce.getDicionario());
                        }
                        if (categoriaOuSubcategoria == 2) {
                            administrador.removerSubcategoria(ecommerce.getDicionario());
                        }
                    }

                    break;

                case 3:
                    System.out.println("Criando uma lista de produtos...");
                    List<Produto> produtos = new ArrayList<>();
                    vendedor.criaProdutos(ecommerce.getDicionario(), produtos);

                    System.out.println("Você quer adicionar os produtos em\n1- Categoria\n2- Subcategoria");
                    int opcaoAdicionarCategoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                    if (opcaoAdicionarCategoriaOuSubcategoria == 1) {
                        vendedor.adicionaProdutosNaCategoria(ecommerce.getDicionario(), produtos);
                    }
                    if (opcaoAdicionarCategoriaOuSubcategoria == 2) {
                        vendedor.adicionaProdutosNaSubcategoria(ecommerce.getDicionario(), produtos);
                        ecommerce.imprimirDicionario();
                    }
                    break;

                case 4:
                    System.out.println("Volte sempre!");
                    break;

                default:
                    System.out.println("Digite entre 1 e 4");
                    break;
            }
        } while (tipoDeUsuario != 4);




    }
}


