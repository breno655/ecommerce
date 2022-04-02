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
        categoriaComida.getSubcategorias().add(SubcategoriaCelular);
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
                                        System.out.println("Metodo ecommerce.imprimirDicionario()");
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
                                                    subcategoriaEscolhida = ecommerce.escolheCategoria(escolhaAsSubcategorias);
                                                    administrador.removerSubcategoria(guardarListaParaRemocao, subcategoriaEscolhida);
                                                    System.out.println("Removido com Sucesso!");
                                                    break;
                                                } else {
                                                    System.out.print("\nDigite UMA para abrir suas Subcategorias: ");
                                                    String escolhaAsSubcategorias = scanner.nextLine();
                                                    subcategoriaEscolhida = ecommerce.escolheCategoria(escolhaAsSubcategorias);
                                                }

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
                                        System.out.print("Editando nome da categoria...\nNome da NOVA categoria: ");
                                        String novoNomeDaCategoria = scanner.nextLine();

                                        administrador.editarCategoria(novoNomeDaCategoria, ecommerce.escolheCategoria(categoriaAEditar));
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

                                        System.out.print("Quantos produtos você deseja adicionar? ");
                                        int quantidadeDeProdutos = Integer.parseInt(scanner.nextLine());
                                        System.out.print("Nome do produto: ");
                                        String nome = scanner.nextLine();
                                        System.out.print("Preço do produto: R$");
                                        float preco = Float.parseFloat(scanner.nextLine());
                                        System.out.print("Descrição do produto: ");
                                        String descricao = scanner.nextLine();
                                        System.out.print("Quantidade de produtos: ");
                                        int quantidade = Integer.parseInt(scanner.nextLine());
                                        System.out.println("");

                                        List<Produto> listaTemporaria = vendedor.criaProdutos(quantidadeDeProdutos, nome, preco, descricao, quantidade);

                                        System.out.println("Você quer adicionar os produtos em\n1- Categoria\n2- Subcategoria");
                                        int opcaoAdicionarCategoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                                        if (opcaoAdicionarCategoriaOuSubcategoria == 1) {
                                            ecommerce.exibeCategorias();
                                            System.out.print("Quer adicionar em qual CATEGORIA? ");
                                            String nomeDaCategoria = scanner.nextLine();
                                            Categoria categoriaEscolhida = ecommerce.escolheCategoria(nomeDaCategoria);
                                            vendedor.adicionaProdutosNaCategoria(categoriaEscolhida, listaTemporaria);
                                        }
                                        if (opcaoAdicionarCategoriaOuSubcategoria == 2) {
                                            ecommerce.exibeCategorias();
                                            System.out.print("Digite UMA para abrir suas Subcategorias: ");
                                            String nomeDaCategoria = scanner.nextLine();
                                            Categoria subcategoriaEscolhida = ecommerce.escolheCategoria(nomeDaCategoria);

                                            while (subcategoriaEscolhida.possuiSubCats()) {
                                                subcategoriaEscolhida.exibeSubcategorias();
                                                System.out.print("\nEscolha uma das opções: ");
                                                String escolhaAsSubcategorias = scanner.nextLine();
                                                subcategoriaEscolhida = ecommerce.escolheCategoria(escolhaAsSubcategorias);
                                            }
                                            vendedor.adicionaProdutosNaSubcategoria(subcategoriaEscolhida, listaTemporaria);
                                        }

                                    } else if (opcaoCrudProduto == 2) {
                                        System.out.println("Metodo ecommerce.imprimirDicionario()");
                                    } else if (opcaoCrudProduto == 3) {

                                        System.out.print("Nome do produto a ser removido? ");
                                        String produtoARemover = scanner.nextLine();

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


