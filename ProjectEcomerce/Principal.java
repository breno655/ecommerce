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
        ecommerce.getDicionario().put("eletronico", categoriaComida);
        Categoria categoriaEletronico = new Categoria("eletronico");
        Categoria SubcategoriaCelular = new Categoria("celular");
        categoriaEletronico.getSubcategorias().add(SubcategoriaCelular);
        ecommerce.getDicionario().put("comida", categoriaEletronico);

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

                                System.out.println("Metodo ecommerce.imprimirDicionario()");
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
                                            System.out.print("Deseja criar quantas Categorias? ");
                                            int quantidadeCategoria = Integer.parseInt(scanner.nextLine());
                                            System.out.print("Nome da Categoria: ");
                                            String nomeNovaCategoria = scanner.nextLine();

                                            administrador.criaCategoria(ecommerce.getDicionario(), nomeNovaCategoria, quantidadeCategoria);
                                        }
                                        if (categoriaOuSubcategoria == 2) {
                                            ecommerce.exibeCategorias();
                                            System.out.print("Deseja criar quantas Subcategorias? ");
                                            int quantidadeSubcategoria = Integer.parseInt(scanner.nextLine());
                                            System.out.print("Em qual Categoria? ");
                                            String qualCategoria = scanner.nextLine();
                                            System.out.print("Nome da Subcategoria: ");
                                            String nomeSubcategoria = scanner.nextLine();

                                            administrador.criaSubcategoria(ecommerce.escolheCategoria(qualCategoria), quantidadeSubcategoria, nomeSubcategoria);

                                        }
                                    } else if (opcaoCrudCategoria == 2) {

                                        System.out.println("* Navegando na LISTA de categorias e subcategorias...");
                                        ecommerce.exibeCategorias();
                                        System.out.print("Digite UMA para abrir suas Subcategorias: ");
                                        String escolhaAsCategorias = scanner.nextLine();
                                        Categoria categoria = ecommerce.escolheCategoria(escolhaAsCategorias);
                                        ecommerce.exibeSubCats(categoria);

                                    } else if (opcaoCrudCategoria == 3) {

                                        System.out.println("REMOVER");
                                        System.out.println("1- Categoria\n2- Subcategoria");
                                        int categoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                                        if (categoriaOuSubcategoria == 1) {
                                            System.out.println("Metodo ecommerce.imprimirDicionario()");
                                            administrador.removerCategoria(ecommerce.getDicionario());
                                        } else if (categoriaOuSubcategoria == 2){

                                            ecommerce.exibeCategorias();
                                            System.out.print("\nDigite UMA para abrir suas Subcategorias: ");
                                            String escolhaAsCategorias = scanner.nextLine();
                                            Categoria subcategoriaEscolhida = ecommerce.escolheCategoria(escolhaAsCategorias);

                                            while (subcategoriaEscolhida.possuiSubCats()) {
                                                subcategoriaEscolhida.exibeSubcategorias();

                                                System.out.print("sua SUBCATEGORIA está aqui? [s/n] ");
                                                String simOuNao = scanner.nextLine();
                                                if (simOuNao.equals("s")) {
                                                    Categoria guardarListaParaRemocao = subcategoriaEscolhida;
                                                    System.out.print("\nDigite qual deseja REMOVER: ");
                                                    String escolhaAsSubcategorias = scanner.nextLine();
                                                    subcategoriaEscolhida = ecommerce.escolheSubCat(escolhaAsSubcategorias, guardarListaParaRemocao);
                                                    administrador.removerSubcategoria(guardarListaParaRemocao, subcategoriaEscolhida);
                                                    System.out.println("Removido com Sucesso!");
                                                    break;
                                                }

                                            }
                                            if (!subcategoriaEscolhida.possuiSubCats()) {
                                                System.out.println(escolhaAsCategorias + " não tem subcategorias");
                                            }

                                            /*System.out.println("REMOÇÃO\nescolha uma as opções: ");
                                            ecommerce.exibeCategorias();
                                            System.out.print("\nEscolha uma para abrir suas Subcategorias: ");
                                            String escolhaAsCategorias = scanner.nextLine();
                                            Categoria subcategoriaEscolhida = ecommerce.escolheCategoria(escolhaAsCategorias);

                                            while (subcategoriaEscolhida.possuiSubCats()) {
                                                subcategoriaEscolhida.exibeSubcategorias();
                                                System.out.print("\nEscolha uma as opções: ");
                                                String escolhaAsSubcategorias = scanner.nextLine();
                                                subcategoriaEscolhida = ecommerce.escolheCategoria(escolhaAsSubcategorias);

                                                System.out.print("REMOVER essa? [s/n] ");
                                                String simOuNao = scanner.nextLine();
                                                if (simOuNao.equals("s")) {
                                                    administrador.removerSubcategoria();
                                                    System.out.println("Removido com Sucesso!");
                                                    break;
                                                }*/
                                        }

                                    } else if (opcaoCrudCategoria == 4) {
                                        ecommerce.exibeCategorias();

                                        System.out.print("Nome da categoria a ser editada? ");
                                        String categoriaAEditar = scanner.nextLine();
                                        System.out.print("Editando nome da categoria...\nNOVO nome da categoria: ");
                                        String novoNomeDaCategoria = scanner.nextLine();
                                        administrador.editarCategoria(novoNomeDaCategoria, ecommerce.escolheCategoria(categoriaAEditar), ecommerce.getDicionario());
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

                                        System.out.println("Criando produtos...");

                                        System.out.print("Nome do produto: ");
                                        String nome = scanner.nextLine();
                                        System.out.print("Preço do produto: R$");
                                        float preco = Float.parseFloat(scanner.nextLine());
                                        System.out.print("Descrição do produto: ");
                                        String descricao = scanner.nextLine();
                                        System.out.print("Quantidade de produtos: ");
                                        int quantidade = Integer.parseInt(scanner.nextLine());
                                        System.out.println("");

                                        Produto produto = vendedor.criaProdutos(nome, preco, descricao, quantidade);

                                        System.out.println("Você quer adicionar os produtos em");
                                        ecommerce.exibeCategorias();
                                        System.out.print("Opção: ");
                                        String nomeDaCategoria = scanner.nextLine();
                                        Categoria categoriaEscolhida = ecommerce.escolheCategoria(nomeDaCategoria);

                                        while (categoriaEscolhida.possuiSubCats()) {
                                            categoriaEscolhida.exibeSubcategorias();
                                            System.out.print("Opção: ");
                                            nomeDaCategoria = scanner.nextLine();
                                            categoriaEscolhida = ecommerce.escolheSubCat(nomeDaCategoria, categoriaEscolhida);
                                            if (categoriaEscolhida.possuiSubCats()) {
                                                vendedor.adicionaProdutosNaSubcategoria(categoriaEscolhida, produto);
                                                break;
                                            }
                                        }

                                    } else if (opcaoCrudProduto == 2) {

                                        System.out.println("* Navegando na LISTA de produtos...");
                                        ecommerce.exibeCategorias();
                                        System.out.print("Digite UMA para abrir em Subcategorias: ");
                                        String escolhaAsCategorias = scanner.nextLine();
                                        Categoria categoria = ecommerce.escolheCategoria(escolhaAsCategorias);
                                        ecommerce.exibeSubCats(categoria);
                                        System.out.print("Digite UMA para abrir em Produtos: ");
                                        String escolhaAsSubcategorias = scanner.nextLine();
                                        Categoria subCat = ecommerce.escolheSubCat(escolhaAsSubcategorias, categoria);
                                        subCat.exibeProdutos();

                                    } else if (opcaoCrudProduto == 3) {

                                        System.out.println("Você quer REMOVER os produtos em");
                                        ecommerce.exibeCategorias();
                                        System.out.print("Opção: ");
                                        String nomeDaCategoria = scanner.nextLine();
                                        Categoria categoriaEscolhida = ecommerce.escolheCategoria(nomeDaCategoria);

                                        while (categoriaEscolhida.possuiSubCats()) {
                                            categoriaEscolhida.exibeSubcategorias();
                                            System.out.print("Opção: ");
                                            nomeDaCategoria = scanner.nextLine();
                                            categoriaEscolhida = ecommerce.escolheSubCat(nomeDaCategoria, categoriaEscolhida);
                                            if (categoriaEscolhida.possuiSubCats()) {
                                                categoriaEscolhida.exibeProdutos();
                                                System.out.println("Opção: ");
                                                String nomeProdutoRemover = scanner.nextLine();
                                                vendedor.removerProdutos(categoriaEscolhida, nomeProdutoRemover);
                                                break;
                                            }
                                        }

                                    } else if (opcaoCrudProduto == 4) {

                                        System.out.println("Você quer EDITAR os produtos em");
                                        ecommerce.exibeCategorias();
                                        System.out.print("Opção: ");
                                        String nomeDaCategoria = scanner.nextLine();
                                        Categoria categoriaEscolhida = ecommerce.escolheCategoria(nomeDaCategoria);

                                        while (categoriaEscolhida.possuiSubCats()) {
                                            categoriaEscolhida.exibeSubcategorias();
                                            System.out.print("Opção: ");
                                            nomeDaCategoria = scanner.nextLine();
                                            categoriaEscolhida = ecommerce.escolheSubCat(nomeDaCategoria, categoriaEscolhida);
                                            if (categoriaEscolhida.possuiSubCats()) {
                                                categoriaEscolhida.exibeProdutos();
                                                System.out.println("Opção: ");
                                                String nomeProdutoEditar = scanner.nextLine();
                                                Produto produto = categoriaEscolhida.escolheProduto(nomeProdutoEditar);

                                                System.out.print("Editar...\n1- Nome\n2- Preço\n3- Descrição\nOpção: ");
                                                int opcaoEditar = Integer.parseInt(scanner.nextLine());

                                                String novoNome = "";
                                                String novaDescricao = "";
                                                float novoPreco = 0;
                                                if (opcaoEditar == 1) {
                                                    System.out.print("Nome do novo produto: ");
                                                    novoNome = scanner.nextLine();
                                                } else if (opcaoEditar == 2) {
                                                    System.out.print("Preço do novo produto: ");
                                                    novoPreco = Float.parseFloat(scanner.nextLine());
                                                } else if (opcaoEditar == 3) {
                                                    System.out.print("Descrição do novo produto: ");
                                                    novaDescricao = scanner.nextLine();
                                                }
                                                vendedor.editarProdutos(opcaoEditar, produto, novoNome, novoPreco, novaDescricao);
                                                break;
                                            }
                                        }

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


