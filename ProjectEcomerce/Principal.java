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

        // adicionei Administrador no dicionario abaixo
        ecommerce.getUsuarios().put("admin", administrador);
        ecommerce.getUsuarios().put("loginbreno", cliente);
        ecommerce.getUsuarios().put("loginpedro", vendedor);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo a Cyber Feira\nGostaria de acessar como: ");

        int tipoDeUsuario;
        do {

            System.out.println("1- Cliente\n2- Administrador\n3- Vendedor\n4- Sair");
            tipoDeUsuario = Integer.parseInt(scanner.nextLine());

            switch (tipoDeUsuario) {
                case 1:

                    System.out.println("1- Fazer Cadastro\n2- Fazer Login");
                    int loginOuCadastro = Integer.parseInt(scanner.nextLine());

                    if (loginOuCadastro == 1) {

                        System.out.print("Seu Nome: ");
                        String nomeCliente = scanner.nextLine();
                        System.out.print("Seu Login: ");
                        String loginCliente = scanner.nextLine();
                        System.out.print("Sua Senha: ");
                        String senhaCliente = scanner.nextLine();

                        cliente = new Cliente(nomeCliente, loginCliente, senhaCliente);
                        ecommerce.getUsuarios().put(loginCliente, cliente);
                    } else if (loginOuCadastro == 2) {
                        boolean logado = false;

                        System.out.print("Seu Login: ");
                        String loginCliente = scanner.nextLine();
                        System.out.print("Sua Senha: ");
                        String senhaCliente = scanner.nextLine();

                        if ((!ecommerce.verficaLogin(loginCliente, senhaCliente))){
                            System.out.println("Não existe ou voce digitou errado");
                        } else {
                            logado = true;
                        }

                        //while (logado == true) {
                           //
                        //}

                    }
                    break;

                case 2:

                    boolean logado = false;

                    System.out.print("Seu Login: ");
                    String loginAdministrador = scanner.nextLine();
                    System.out.print("Sua Senha: ");
                    String senhaAdministrador = scanner.nextLine();

                    if ((!ecommerce.verficaLogin(loginAdministrador, senhaAdministrador))){
                        System.out.println("Não existe ou voce digitou errado");
                    } else {
                        logado = true;
                    }

                    while (logado == true) {

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

                    }
                    break;

                case 3:

                    System.out.println("1- Fazer Cadastro\n2- Fazer Login");
                    loginOuCadastro = Integer.parseInt(scanner.nextLine());

                    if (loginOuCadastro == 1) {

                        System.out.print("Seu Nome: ");
                        String nomeVendendor = scanner.nextLine();
                        System.out.print("Seu Login: ");
                        String loginVendendor = scanner.nextLine();
                        System.out.print("Sua Senha: ");
                        String senhaVendendor = scanner.nextLine();

                        vendedor = new Vendedor(nomeVendendor, loginVendendor, senhaVendendor);
                        ecommerce.getUsuarios().put(loginVendendor, vendedor);

                    } else if (loginOuCadastro == 2) {

                        System.out.print("Seu Login: ");
                        String loginVendedor = scanner.nextLine();
                        System.out.print("Sua Senha: ");
                        String senhaVendedor = scanner.nextLine();

                        if ((!ecommerce.verficaLogin(loginVendedor, senhaVendedor))) {
                            System.out.println("Não existe ou voce digitou errado");
                        } else {

                            int opcaoCrudCategoria;
                            do {
                                System.out.println("- Manipulando Produtos -\n1- CRIAR" +
                                        "\n2- LISTAR\n3- REMOVER\n4- EDITAR\n5- deslogar");
                                opcaoCrudCategoria = Integer.parseInt(scanner.nextLine());

                                if (opcaoCrudCategoria == 1) {
                                    System.out.println("kl");
                                }

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

                            } while (opcaoCrudCategoria != 5);
                        }

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


