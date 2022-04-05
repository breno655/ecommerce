package ProjectEcomerce;

import Entidades.*;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Ecommerce ecommerce = new Ecommerce();

        Vendedor vendedorPadrao = new Vendedor("pedro", "loginpedro", "senhapedro");
        Administrador administrador = new Administrador("thiago", "admin", "admin");
        Cliente clientePadrao = new Cliente("breno", "loginbreno", "senhabreno");

        // adicionei alguns usuarios no dicionarioUsuario, abaixo
        ecommerce.getUsuarios().put("admin", administrador);
        ecommerce.getUsuarios().put("loginbreno", clientePadrao);
        ecommerce.getUsuarios().put("loginpedro", vendedorPadrao);

        // adicionei algumas categorias e produtos no dicionarioDosProdutos, abaixo
        Categoria categoriaJogo = new Categoria("jogo");
        Categoria subcategoriaFps = new Categoria("fps");
        Produto produtoValorant = new Produto("valorant", 120, "melhor jogo de tiro", 100);
        categoriaJogo.getSubcategorias().add(subcategoriaFps);
        ecommerce.getDicionario().put("jogo", categoriaJogo);
        subcategoriaFps.getProdutos().add(produtoValorant);
        ecommerce.getTodosOsProdutosDoEcommerce().add(produtoValorant);

        Categoria categoriaEletronico = new Categoria("eletronico");
        Categoria subcategoriaCelular = new Categoria("celular");
        Produto produtoIphone = new Produto("iphone", 5000, "última geração", 100);
        categoriaEletronico.getSubcategorias().add(subcategoriaCelular);
        ecommerce.getDicionario().put("eletronico", categoriaEletronico);
        subcategoriaCelular.getProdutos().add(produtoIphone);
        ecommerce.getTodosOsProdutosDoEcommerce().add(produtoIphone);

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBem-vindo a Cyber Feira");

        int tipoDeUsuario;
        do {

            System.out.print("Gostaria de acessar como:\n1- Cliente\n2- Administrador\n3- Vendedor\n4- Sair\n- Opção: ");
            tipoDeUsuario = Integer.parseInt(scanner.nextLine());

            System.out.print("\n1- Fazer Cadastro\n2- Fazer Login\n- Opção: ");
            int loginOuCadastro = Integer.parseInt(scanner.nextLine());

            if (loginOuCadastro == 1 && tipoDeUsuario == 2) {
                System.out.println("Erro! Não pode existir mais de um Administrador\n");
            } else if (loginOuCadastro == 1) {
                System.out.println("\nCADASTRO");

                System.out.print("Seu Nome: ");
                String nomeUsuario = scanner.nextLine();
                System.out.print("Seu Login: ");
                String loginUsuario = scanner.nextLine();
                System.out.print("Sua Senha: ");
                String senhaUsuario = scanner.nextLine();

                ecommerce.cadastro(tipoDeUsuario, nomeUsuario, loginUsuario, senhaUsuario, ecommerce);

            } else if (loginOuCadastro == 2) {
                System.out.println("\nLOGIN");

                System.out.print("Seu Login: ");
                String loginUsuario = scanner.nextLine();
                System.out.print("Sua Senha: ");
                String senhaUsuario = scanner.nextLine();

                boolean logado = ecommerce.login(loginUsuario, senhaUsuario, ecommerce);
                if (logado) {

                    switch (tipoDeUsuario) {
                        case 1:

                            int opcaoCliente;
                            do {
                                Cliente cliente = (Cliente) ecommerce.buscarUsuario(loginUsuario);

                                System.out.print("\n1- Buscar Produto\n2- Explorar as categorias e produtos" +
                                        "\n3- Ver o carrinho de compras\n4- Finalizar sua Compra\n5- deslogar\n- Opção: ");
                                opcaoCliente = Integer.parseInt(scanner.nextLine());

                                if (opcaoCliente == 1) {
                                    System.out.println("Buscar produtos...");
                                    System.out.print("Buscando por: ");
                                    String produtoBuscado = scanner.nextLine();
                                    Produto produto = ecommerce.buscarProdutos(produtoBuscado);
                                    if (produto != null) {
                                        System.out.println("\n  Produto: " + produtoBuscado.toUpperCase() + "\n" + produto.toStringCliente());
                                    } else {
                                        System.out.println("Erro! Produto não encontrado");
                                    }
                                    System.out.print("Quer adicionar ao seu carrinho? [s/n] ");
                                    String simOuNao = scanner.nextLine();
                                    if (simOuNao.equals("s")) {
                                        cliente.adicionarNoCarrinho(produto);
                                        cliente.getCarrinhoDeCompras().fazPrecoTotalDoCarrinho();
                                    }
                                } else if (opcaoCliente == 2) {

                                    System.out.println("Explorar as categorias e produtos");
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
                                            System.out.print("Escolha um para ver seus detalhes: ");
                                            String opcaoAbrirDetalhes = scanner.nextLine();
                                            Produto produto = categoriaEscolhida.escolheProduto(opcaoAbrirDetalhes);
                                            if (produto != null) {
                                                System.out.println("\n  " + opcaoAbrirDetalhes.toUpperCase() + "\n" + produto.toStringCliente());
                                                System.out.print("Quer adicionar ao seu carrinho? [s/n] ");
                                                String simOuNao = scanner.nextLine();
                                                if (simOuNao.equals("s")) {
                                                    cliente.adicionarNoCarrinho(produto);
                                                    cliente.getCarrinhoDeCompras().fazPrecoTotalDoCarrinho();
                                                }
                                            }
                                            break;
                                        }
                                    }
                                } else if (opcaoCliente == 3) {
                                    System.out.println("Seu carrinho de compras...");
                                    cliente.exibeProdutosDoCarrinho();
                                } else if (opcaoCliente == 4) {

                                    System.out.println("\nFinalizar Compras...");
                                    System.out.println("------------------------");
                                    cliente.exibeProdutosDoCarrinho();
                                    System.out.println("------------------------");

                                    System.out.println(" - Suas Informações - ");
                                    if (cliente.vericaEndereco()) {
                                        System.out.println("Endereço: " + cliente.getEndereco());
                                    } else {
                                        System.out.print("Informe seu Endereço: ");
                                        String endereco = scanner.nextLine();
                                        cliente.setEndereco(endereco);
                                    }
                                    if (cliente.vericaSaldo()){
                                        System.out.println("Saldo disponivel: R$" + cliente.getSaldo());
                                    } else {
                                        System.out.print("Informe seu Saldo: R$");
                                        float saldo = Float.parseFloat(scanner.nextLine());
                                        cliente.setSaldo(saldo);
                                    }

                                    System.out.print("Valor total da compra: R$");
                                    cliente.exibePrecoTotalDaCompra();

                                    System.out.println("\n------------------------");

                                    System.out.print("Confirmar compra? [s/n] ");
                                    String simOuNao = scanner.nextLine();

                                    if (simOuNao.equals("s")) {
                                        boolean saldoSuficiente = cliente.getCarrinhoDeCompras().verificaSaldoSuficienteParaCompra(cliente);
                                        if (saldoSuficiente) {
                                            Pedido pedido = new Pedido();
                                            pedido.registraPedido(cliente);
                                            System.out.println("\nCompra confirmada! Seu pedido será entregue em instantes");
                                        } else {
                                            System.out.println("!Erro... Saldo Insuficiente :(");
                                        }
                                    } else {
                                        System.out.println("* Sua compra não foi realizada *");
                                    }
                                }

                            } while (opcaoCliente != 5);

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
                                        System.out.print("Em qual Categoria? ");
                                        String qualCategoria = scanner.nextLine();
                                        System.out.print("Nome da Subcategoria: ");
                                        String nomeSubcategoria = scanner.nextLine();

                                        administrador.criaSubcategoria(ecommerce.escolheCategoria(qualCategoria), nomeSubcategoria);

                                    }
                                } else if (opcaoCrudCategoria == 2) {
                                    System.out.println("LISTAR\n1- Lista de categorias e subcategorias\n2- Lista de vendedores" +
                                            "\nOpção: ");
                                    int opcaoLista = Integer.parseInt(scanner.nextLine());

                                    if (opcaoLista == 1) {
                                        System.out.println("\n* Navegando na LISTA de categorias e subcategorias...");
                                        ecommerce.exibeCategorias();
                                        System.out.print("Digite UMA para abrir suas Subcategorias: ");
                                        String escolhaAsCategorias = scanner.nextLine();
                                        Categoria categoria = ecommerce.escolheCategoria(escolhaAsCategorias);
                                        ecommerce.exibeSubCats(categoria);
                                    } else if (opcaoLista == 2) {
                                        System.out.println("- Vendedores e Clientes -");
                                        ecommerce.exibeUsuarios();
                                        System.out.print("Escolha uma das opções para detalhes: ");
                                        String opcaoUsuario = scanner.nextLine();
                                        Vendedor usuario = (Vendedor) ecommerce.escolheUsuarios(opcaoUsuario);
                                        //abaixo tem que criar uma excecao pra uma possibilidade de nao ter produtos para nao dar nulo
                                        usuario.exibeProdutosVendedor();
                                    }

                                } else if (opcaoCrudCategoria == 3) {

                                    System.out.println("REMOVER");
                                    System.out.println("1- Categoria\n2- Subcategoria");
                                    int categoriaOuSubcategoria = Integer.parseInt(scanner.nextLine());

                                    if (categoriaOuSubcategoria == 1) {
                                        System.out.println("Falta essa função linha 152 main");
                                        administrador.removerCategoria(ecommerce.getDicionario());
                                    } else if (categoriaOuSubcategoria == 2) {

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
                                Vendedor vendedor = (Vendedor) ecommerce.buscarUsuario(loginUsuario);

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

                                    Produto produto = vendedor.criaProdutos(nome, preco, descricao, quantidade, ecommerce);

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
                                            vendedor.removerProdutos(categoriaEscolhida, nomeProdutoRemover, ecommerce);
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
                                            System.out.print("Opção: ");
                                            String nomeProdutoEditar = scanner.nextLine();
                                            Produto produto = categoriaEscolhida.escolheProduto(nomeProdutoEditar);

                                            System.out.print("\nEditar...\n1- Nome\n2- Preço\n3- Descrição\nOpção: ");
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
            }
        } while (tipoDeUsuario != 4) ;
    }
}