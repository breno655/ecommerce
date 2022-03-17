package ProjectEcomerce;

import Entidades.Administrador;
import Entidades.Ecommerce;
import Entidades.Vendedor;

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
                    System.out.println("1- Categoria\n2- Subcategoria");
                    int categoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                    if (categoriaOuSubcategoria == 1) {
                        administrador.criaCategoria(ecommerce.getDicionario());
                        administrador.criaSubcategoria(ecommerce.getDicionario());
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


