package ProjectEcomerce;

import Entidades.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Ecommerce ecommerce = new Ecommerce();

        Vendedor vendedor = new Vendedor("Pedro", "loginpedro", "senhapedro");
        Administrador administrador = new Administrador("Thiago", "admin", "admin");
        Cliente cliente = new Cliente("Breno", "loginbreno", "senhabreno");

        // adicionei alguns usuarios no dicionarioUsuario, abaixo
        ecommerce.getUsuarios().put("admin", administrador);
        ecommerce.getUsuarios().put("loginbreno", cliente);
        ecommerce.getUsuarios().put("loginpedro", vendedor);

        // adicionei algumas categorias e produtos no dicionarioDosProdutos, abaixo
        Categoria categoriaComida = new Categoria("comida");
        Categoria SubcategoriaJaponesa = new Categoria("japonesa");
        categoriaComida.getSubcategorias().add(SubcategoriaJaponesa);
        ecommerce.getDicionario().put(categoriaComida, null);

        Scanner scanner = new Scanner(System.in);

        int tipoDeUsuario;
        do {
            System.out.println("\nBem-vindo a Cyber Feira");

            System.out.println("1- Fazer Cadastro\n2- Fazer Login");
            int loginOuCadastro = Integer.parseInt(scanner.nextLine());

            System.out.println("Gostaria de acessar como:\n1- Cliente\n2- Administrador\n3- Vendedor\n4- Sair");
            tipoDeUsuario = Integer.parseInt(scanner.nextLine());

            if (loginOuCadastro == 1) {
                System.out.println("CADASTRO");

                System.out.print("Seu Nome: ");
                String nomeUsuario = scanner.nextLine();
                System.out.print("Seu Login: ");
                String loginUsuario = scanner.nextLine();
                System.out.print("Sua Senha: ");
                String senhaUsuario = scanner.nextLine();

                if (tipoDeUsuario == 1) {

                    cliente = new Cliente(nomeUsuario, loginUsuario, senhaUsuario);
                    ecommerce.getUsuarios().put(loginUsuario, cliente);

                } else if (tipoDeUsuario == 2) {

                    System.out.println("Não pode ser criado mais de um ADMINISTRADOR");

                } else if (tipoDeUsuario == 3) {

                    vendedor = new Vendedor(nomeUsuario, loginUsuario, senhaUsuario);
                    ecommerce.getUsuarios().put(loginUsuario, vendedor);

                }

            } else if (loginOuCadastro == 2) {
                System.out.println("LOGIN");

                System.out.print("Seu Login: ");
                String loginUsuario = scanner.nextLine();
                System.out.print("Sua Senha: ");
                String senhaUsuario = scanner.nextLine();

                if (ecommerce.buscarUsuario(loginUsuario)) {

                    if ((!ecommerce.verficaLogin(loginUsuario, senhaUsuario))) {

                        System.out.println("Não existe ou voce digitou errado");

                    } else {

                        switch (tipoDeUsuario) {
                            case 1:

                                ecommerce.imprimirDicionario();
                                break;

                            case 2:

                                int opcaoCrudCategoria;
                                do {
                                    System.out.println("\n- Manipulando Categorias e Subcategorias -\n1- CRIAR" +
                                            "\n2- LISTAR\n3- REMOVER\n4- EDITAR\n5- deslogar");
                                    opcaoCrudCategoria = Integer.parseInt(scanner.nextLine());

                                    if (opcaoCrudCategoria == 1) {
                                        System.out.println("1- Categoria\n2- Subcategoria");
                                        int categoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                                        if (categoriaOuSubcategoria == 1) {
                                            administrador.criaCategoria(ecommerce.getDicionario());
                                        }
                                        if (categoriaOuSubcategoria == 2) {
                                            administrador.criaSubcategoria(ecommerce.getDicionario());
                                        }
                                    } else if (opcaoCrudCategoria == 2) {
                                        ecommerce.imprimirDicionario();
                                    } else if (opcaoCrudCategoria == 3) {

                                        System.out.println("REMOVER");
                                        System.out.println("1- Categoria\n2- Subcategoria");
                                        int categoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                                        if (categoriaOuSubcategoria == 1) {
                                            ecommerce.imprimirDicionario();
                                            administrador.removerCategoria(ecommerce.getDicionario());
                                        } else if (categoriaOuSubcategoria == 2){
                                            ecommerce.imprimirDicionario();
                                            administrador.removerSubcategoria(ecommerce.getDicionario());
                                        }

                                    } else if (opcaoCrudCategoria == 4) {
                                        administrador.editarCategoria(ecommerce.getDicionario());
                                    }

                                } while (opcaoCrudCategoria != 5);
                                break;

                            case 3:

                                int opcaoCrudProduto;
                                do {
                                    System.out.println("\n- Manipulando Produtos -\n1- CRIAR" +
                                            "\n2- LISTAR\n3- REMOVER\n4- EDITAR\n5- deslogar");
                                    opcaoCrudProduto = Integer.parseInt(scanner.nextLine());

                                    if (opcaoCrudProduto == 1) {

                                        System.out.println("Criando uma lista de produtos...");
                                        List<Produto> produtos = new ArrayList<>();
                                        vendedor.criaProdutos(ecommerce.getDicionario(), produtos);

                                        System.out.println("Você quer adicionar os produtos em\n1- Categoria\n2- Subcategoria");
                                        int opcaoAdicionarCategoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                                        if (opcaoAdicionarCategoriaOuSubcategoria == 1) {
                                            vendedor.adicionaProdutosNaCategoria(ecommerce.getDicionario(), produtos);
                                            ecommerce.imprimirDicionario();
                                        }
                                        if (opcaoAdicionarCategoriaOuSubcategoria == 2) {
                                            vendedor.adicionaProdutosNaSubcategoria(ecommerce.getDicionario(), produtos);
                                            ecommerce.imprimirDicionario();
                                        }

                                    } else if (opcaoCrudProduto == 2) {
                                        ecommerce.imprimirDicionario();
                                    } else if (opcaoCrudProduto == 3) {
                                        ecommerce.imprimirDicionario();
                                        vendedor.removerProdutos(ecommerce.getDicionario());
                                    } else if (opcaoCrudProduto == 4) {
                                        vendedor.editarProdutos(ecommerce.getDicionario());
                                    }

                                } while (opcaoCrudProduto != 5);
                                break;

                            case 4:
                                System.out.println("Volte sempre!");
                                break;

                            default:
                                System.out.println("Digite entre 1 e 4");
                                break;
                        }

                    }
                } else {
                    System.out.println("O usuário nao existe!");
                }
            }
        } while (tipoDeUsuario != 4);
    }
}


