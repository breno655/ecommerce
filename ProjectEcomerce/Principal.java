package ProjectEcomerce;

import java.util.Scanner;

import Entidades.*;
import Services.NavCategoria;
import enums.ProdutoEnum;

public class Principal {

    public static void main(String[] args) {

        Ecommerce ecommerce = new Ecommerce();

        Vendedor vendedorPadrao = new Vendedor("pedro", "pp", "pp", 3);
        Administrador administrador = new Administrador("thiago", "admin", "admin", 2);
        Cliente clientePadrao = new Cliente("breno", "br", "br", 1);

        // adicionei alguns usuarios no dicionarioUsuario, abaixo
        ecommerce.getUsuarios().put("admin", administrador);
        ecommerce.getUsuarios().put("loginbreno", clientePadrao);
        ecommerce.getUsuarios().put("loginpedro", vendedorPadrao);

        // adicionei algumas categorias e produtos no dicionarioDosProdutos, abaixo
        Categoria categoriaJogo = new Categoria("jogo");
        Categoria subcategoriaFps = new Categoria("fps");
        Produto produtoValorant = new Produto("valorant", 120, "melhor jogo de tiro", 100, 5555, ProdutoEnum.NÃO_ENVIADO);
        categoriaJogo.getSubcategorias().add(subcategoriaFps);
        ecommerce.getDicionario().put("jogo", categoriaJogo);
        subcategoriaFps.getProdutos().add(produtoValorant);
        ecommerce.getTodosOsProdutosDoEcommerce().put(5555, produtoValorant);

        Categoria categoriaEletronico = new Categoria("eletronico");
        Categoria subcategoriaCelular = new Categoria("celular");
        Produto produtoIphone = new Produto("iphone", 5000, "Ãºltima geraÃ§Ã£o", 100, 8888, ProdutoEnum.NÃO_ENVIADO);
        categoriaEletronico.getSubcategorias().add(subcategoriaCelular);
        ecommerce.getDicionario().put("eletronico", categoriaEletronico);
        subcategoriaCelular.getProdutos().add(produtoIphone);
        ecommerce.getTodosOsProdutosDoEcommerce().put(8888, produtoIphone);

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBem-vindo a Cyber Feira");

        int codigoUsuario;
        do {

            System.out.print("Gostaria de acessar como:\n1- Cliente\n2- Administrador\n3- Vendedor\n4- Sair\n- Opção: ");
            codigoUsuario = Integer.parseInt(scanner.nextLine());

            if (codigoUsuario >= 4) {
                System.out.println("\nVocê optou por sair,\nprograma encerrado com sucesso.");
                System.exit(0);
            }

            System.out.print("\n1- Fazer Cadastro\n2- Fazer Login\n- Opção: ");
            int loginOuCadastro = Integer.parseInt(scanner.nextLine());

            if (loginOuCadastro == 1 && codigoUsuario == 2) {
                System.out.println("Erro! Não pode existir mais de um Administrador\n");
            } else if (loginOuCadastro == 1) {
                System.out.println("\nCADASTRO");

                System.out.print("Seu Nome: ");
                String nomeUsuario = scanner.nextLine();
                System.out.print("Seu Login: ");
                String loginUsuario = scanner.nextLine();
                System.out.print("Sua Senha: ");
                String senhaUsuario = scanner.nextLine();

                ecommerce.cadastro(codigoUsuario, nomeUsuario, loginUsuario, senhaUsuario, ecommerce);

            } else if (loginOuCadastro == 2) {
                System.out.println("\nLOGIN");

                System.out.print("Seu Login: ");
                String loginUsuario = scanner.nextLine();
                System.out.print("Sua Senha: ");
                String senhaUsuario = scanner.nextLine();

                boolean logado = ecommerce.login(loginUsuario, senhaUsuario, codigoUsuario, ecommerce);
                if (logado) {

                    switch (codigoUsuario) {
                        case 1:

                            int opcaoCliente;
                            do {
                                Cliente cliente = (Cliente) ecommerce.buscarUsuario(loginUsuario);

                                System.out.print("\n1- Buscar Produto\n2- Explorar as categorias e produtos" +
                                        "\n3- Ver o carrinho de compras\n4- Finalizar sua Compra\n" +
                                        "5- Adicionar saldo em conta\n6- Histórico de pedidos\n7- Deslogar\n- OpÃ§Ã£o: ");
                                opcaoCliente = Integer.parseInt(scanner.nextLine());

                                if (opcaoCliente == 1) {
                                    System.out.println("Buscar produtos...");
                                    System.out.print("Buscando por: ");
                                    String produtoBuscado = scanner.nextLine();
                                    Produto produto = ecommerce.buscarProdutos(produtoBuscado);
                                    if (produto != null) {
                                        System.out.println("\n  Produto: " + produtoBuscado.toUpperCase() + "\n" + produto);
                                    } else {
                                        System.out.println("Erro! Produto nÃ£o encontrado");
                                    }
                                    System.out.print("Quer adicionar ao seu carrinho? [s/n] ");
                                    String simOuNao = scanner.nextLine();
                                    if (simOuNao.equals("s")) {
                                        cliente.adicionarNoCarrinho(produto);
                                        cliente.getCarrinhoDeCompras().fazPrecoTotalDoCarrinho();
                                    }
                                } else if (opcaoCliente == 2) {
                                    NavCategoria navCategoria = new NavCategoria();

                                    System.out.println("Explorar as categorias e produtos");

                                    Categoria subComProd = navCategoria.navegaCategoria(ecommerce);
                                    Produto produto = navCategoria.detalheDoProduto(subComProd);
                                    System.out.println("Detalhes: \n" + produto);

                                    System.out.print("Quer adicionar ao seu carrinho? [s/n] ");
                                    String simOuNao = scanner.nextLine();
                                    if (simOuNao.equals("s")) {
                                        cliente.adicionarNoCarrinho(produto);
                                        cliente.getCarrinhoDeCompras().fazPrecoTotalDoCarrinho();
                                    }

                                } else if (opcaoCliente == 3) {
                                    System.out.println("Seu carrinho de compras...");
                                    cliente.exibeProdutosDoCarrinho();
                                } else if (opcaoCliente == 4) {

                                    System.out.println("\nFinalizar Compras...");
                                    System.out.println("------------------------");
                                    cliente.exibeProdutosDoCarrinho();
                                    System.out.println("------------------------");

                                    System.out.println(" - Suas InformaÃ§Ãµes - ");
                                    if (cliente.verificaEndereco()) {
                                        System.out.println("EndereÃ§o: " + cliente.getEndereco());
                                    } else {
                                        System.out.print("Informe seu EndereÃ§o: ");
                                        String endereco = scanner.nextLine();
                                        cliente.setEndereco(endereco);
                                    }
                                    if (cliente.verificaSaldo()) {
                                        System.out.println("Saldo disponivel: R$" + cliente.getSaldoCliente());

                                        System.out.print("Valor total da compra: R$");
                                        cliente.exibePrecoTotalDaCompra();

                                        System.out.println("\n------------------------");

                                        System.out.print("Confirmar compra? [s/n] ");
                                        String simOuNao = scanner.nextLine();

                                        if (simOuNao.equals("s")) {
                                            boolean saldoSuficiente = cliente.getCarrinhoDeCompras().verificaSaldoSuficienteParaCompra(cliente);
                                            if (saldoSuficiente) {
                                                //cliente.getPedidos().registraPedido(cliente);

                                                cliente.registraPedido(); // aqui ele coleta os produtos do carrinho e registra como pedido efetuado

                                                System.out.println("\nCompra confirmada! Seu pedido serÃ¡ entregue em instantes");
                                            } else {
                                                System.out.println("!Erro... Saldo Insuficiente :(");
                                            }
                                        } else {
                                            System.out.println("* Sua compra nÃ£o foi realizada *");
                                        }
                                    }
                                } else if (opcaoCliente == 5) {
                                    System.out.println("Saldo a adicionar: !");
                                    float saldo = Float.parseFloat(scanner.nextLine());
                                    //cliente.setSaldo(saldo);
                                    if (cliente.adicionaSaldo(saldo)) {
                                        System.out.println("Saldo adicionado com sucesso!");
                                        System.out.println("Saldo atual: !" + cliente.getSaldoCliente());
                                    }
                                } else if (opcaoCliente == 6) {
                                    System.out.println("- Histórico de pedidos - ");
                                    for (Pedido pedido : cliente.getPedidosRegistrados().values()) {
                                        System.out.println(pedido.getProdutosDoPedido());
                                        for (Produto produto : pedido.getProdutosDoPedido()) {
                                            System.out.println(produto.toString());
                                        }
                                    }
                                }else if (opcaoCliente == 7) {
                                    System.out.println("Você foi deslogado com sucesso!");
                                    main(args);
                                }
                            }

                            while (opcaoCliente < 8);

                            break;

                        case 2:

                            int opcaoCrudCategoria;
                            do {
                                System.out.println("\n- Manipulando Categorias e Subcategorias -\n1- CRIAR" +
                                        "\n2- LISTAR\n3- REMOVER\n4- EDITAR\n5- DESLOGAR");
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
                                    else if (categoriaOuSubcategoria == 2) {
                                        ecommerce.exibeCategorias();
                                        System.out.print("Em qual Categoria? ");
                                        String qualCategoria = scanner.nextLine();
                                        System.out.print("Nome da Subcategoria: ");
                                        String nomeSubcategoria = scanner.nextLine();

                                        administrador.criaSubcategoria(ecommerce.escolheCategoria(qualCategoria), nomeSubcategoria);

                                    }
                                } else if (opcaoCrudCategoria == 2) {
                                    System.out.println("LISTAR\n1- Lista de categorias e subcategorias\n2- Lista de vendedores" +
                                            "\nOpÃ§Ã£o: ");
                                    int opcaoLista = Integer.parseInt(scanner.nextLine());

                                    if (opcaoLista == 1) {
                                        System.out.println("\n* Navegando na LISTA de categorias e subcategorias...");
                                        ecommerce.exibeCategorias();
                                        System.out.print("Digite UMA para abrir suas Subcategorias: ");
                                        String escolhaAsCategorias = scanner.nextLine();
                                        Categoria categoria = ecommerce.escolheCategoria(escolhaAsCategorias);
                                        ecommerce.exibeSubCats(categoria);
                                    } else if (opcaoLista == 2) {
                                        System.out.println("- Vendedores -");
                                        int codigoDoVendedor = new Vendedor().getCodigoVendedor();
                                        ecommerce.exibeUsuarios(codigoDoVendedor);
                                        System.out.print("Escolha uma das opÃ§Ãµes para detalhes: ");
                                        String opcaoUsuario = scanner.nextLine();
                                        Vendedor vendedor = (Vendedor) ecommerce.escolheUsuarios(opcaoUsuario);
                                        //abaixo tem que criar uma excecao pra uma possibilidade de nao ter produtos para nao dar nulo
                                        vendedor.exibeProdutosVendedor();
                                    }

                                } else if (opcaoCrudCategoria == 3) {
                                    NavCategoria navCategoria = new NavCategoria();

                                    System.out.println("REMOVER CATEGORIAS");

                                    Categoria categoriaFilho = navCategoria.navegaCategoria(ecommerce);
                                    Categoria categoriaPai = ecommerce.achaCategoriaAcima(categoriaFilho);
                                    boolean operacao = categoriaPai.removeCategoria(categoriaFilho);
                                    if (operacao) {
                                        System.out.println("Removido com sucesso: " + categoriaFilho.getNome());
                                    }
                                    System.out.println("ERRO!");

                                } else if (opcaoCrudCategoria == 4) {
                                    ecommerce.exibeCategorias();

                                    System.out.print("Nome da categoria a ser editada? ");
                                    String categoriaAEditar = scanner.nextLine();
                                    System.out.print("Editando nome da categoria...\nNOVO nome da categoria: ");
                                    String novoNomeDaCategoria = scanner.nextLine();
                                    administrador.editarCategoria(novoNomeDaCategoria, ecommerce.escolheCategoria(categoriaAEditar), ecommerce.getDicionario());
                                }

                            } while (opcaoCrudCategoria != 5);
                            main(args);

                        case 3:

                            int opcaoCrudProduto;
                            do {
                                Vendedor vendedor = (Vendedor) ecommerce.buscarUsuario(loginUsuario);

                                System.out.println("\n- Manipulando Produtos -\n1- CRIAR" +
                                        "\n2- LISTAR\n3- REMOVER\n4- EDITAR\n5- DESLOGAR");
                                opcaoCrudProduto = Integer.parseInt(scanner.nextLine());

                                if (opcaoCrudProduto == 1) {
                                    NavCategoria navCategoria = new NavCategoria();

                                    System.out.println("Criando produtos...");

                                    System.out.print("Nome do produto: ");
                                    String nome = scanner.nextLine();
                                    System.out.print("PreÃ§o do produto: R$");
                                    float preco = Float.parseFloat(scanner.nextLine());
                                    System.out.print("DescriÃ§Ã£o do produto: ");
                                    String descricao = scanner.nextLine();
                                    System.out.print("Quantidade de produtos: ");
                                    int quantidade = Integer.parseInt(scanner.nextLine());
                                    System.out.println("");

                                    Produto produto = vendedor.criaProdutos(nome, preco, descricao, quantidade, ecommerce);

                                    System.out.println("VocÃª quer adicionar os produtos em");

                                    Categoria categoria = navCategoria.navegaCategoria(ecommerce);
                                    vendedor.adicionaProdutosNaSubcategoria(categoria, produto);

                                } else if (opcaoCrudProduto == 2) {

                                    System.out.println("* Navegando na LISTA de produtos...");

                                    vendedor.exibeProdutosVendedor();
                                    System.out.print("Abrir seus detalhes: ");
                                    String nomeProduto = scanner.nextLine();
                                    Produto produtoEscolhido = vendedor.escolheProdVend(nomeProduto);
                                    System.out.println("Nome: " + produtoEscolhido.getNome()
                                            + "\nCódigo de Barras: " + produtoEscolhido.getCodigoProduto()
                                            + "\nStatus de Envio: " + produtoEscolhido.getStatus()
                                            + "\nPreço: " + produtoEscolhido.getPreco()
                                            + "\nDescrição: " + produtoEscolhido.getDescricao()
                                            + "\nQuantidade: " + produtoEscolhido.getQuantidade());

                                } else if (opcaoCrudProduto == 3) {
                                    NavCategoria navCategoria = new NavCategoria();

                                    System.out.println("REMOVER PRODUTOS");

                                    Categoria categoria = navCategoria.navegaCategoria(ecommerce);
                                    Produto produto = navCategoria.detalheDoProduto(categoria);
                                    vendedor.removerProdutos(categoria, produto, ecommerce);
                                    System.out.println("Removido");

                                } else if (opcaoCrudProduto == 4) {
                                    NavCategoria navCategoria = new NavCategoria();

                                    System.out.println("VocÃª quer EDITAR os produtos em");

                                    Categoria categoria = navCategoria.navegaCategoria(ecommerce);
                                    Produto produto = navCategoria.detalheDoProduto(categoria);

                                    System.out.print("\nEditar...\n1- Nome\n2- Preço\n3- Descrição\n4- Status\nOpÃ§Ã£o: ");
                                    int opcaoEditar = Integer.parseInt(scanner.nextLine());

                                    String novoNome = "";
                                    String novaDescricao = "";
                                    float novoPreco = 0;
                                    if (opcaoEditar == 1) {
                                        System.out.print("Nome do novo produto: ");
                                        novoNome = scanner.nextLine();
                                    } else if (opcaoEditar == 2) {
                                        System.out.print("PreÃ§o do novo produto: ");
                                        novoPreco = Float.parseFloat(scanner.nextLine());
                                    } else if (opcaoEditar == 3) {
                                        System.out.print("DescriÃ§Ã£o do novo produto: ");
                                        novaDescricao = scanner.nextLine();
                                    }else if (opcaoEditar == 4) {
                                        System.out.println("Status: "
                                                + "\nNÃO_ENVIADO"
                                                + "\nENVIADO"
                                                + "\nENTREGUE\n ");
                                        String novoStatus = scanner.nextLine();
                                        produto.alteraStatus(novoStatus.toUpperCase());
                                        System.out.println("Status do produto alterado para: "+ produto.getStatus());

                                    }

                                    vendedor.editarProdutos(opcaoEditar, produto, novoNome, novoPreco, novaDescricao);

                                }
                            } while (opcaoCrudProduto != 5);
                            main(args);

                        default:
                            System.out.println("Digite entre 1 e 4");
                            break;
                    }
                }
            } if (loginOuCadastro>2) {
                main(args);
            }
        } while (codigoUsuario < 4);
        System.out.println("Volte sempre!");
    }
}