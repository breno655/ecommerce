package ProjectEcomerce;

import Entidades.Administrador;
import Entidades.Produto;
import Entidades.Vendedor;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Ecommerce ecommerce = new Ecommerce();
        Vendedor vendedor = new Vendedor();
        Administrador administrador = new Administrador();

        Scanner scanner = new Scanner(System.in);

        int tipoDeUsuario;
        do {
            System.out.println("1- Cliente\n2- Administrador\n3- Vendedor\n4- Sair");
            tipoDeUsuario = Integer.parseInt(scanner.nextLine());

            switch (tipoDeUsuario) {
                case 1:
                    break;

                case 2:
                    System.out.print("1.CATEGORIA ou 2.SUBCATEGORIA? ");
                    int categoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                    if (categoriaOuSubcategoria == 1) {
                        administrador.criaCategoria(ecommerce.getDicionario());
                    }

                    break;

                case 3:
                    vendedor.adicionaProdutoEmCategoria(ecommerce.getDicionario());
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


