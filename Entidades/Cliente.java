package Entidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente extends Usuario {

    private CarrinhoDeCompras carrinhoDeCompras;
    private String endereco;
    private float saldoCliente;
    private Map<Integer, Float> precosTotais;
    private Map<Integer, Pedido> pedidosRegistrados;

    public Cliente() {

    }

    public Cliente(String nome, String login, String senha, int codigo) {
        super(nome, login, senha, codigo);
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.codigo = 1;
        this.carrinhoDeCompras = new CarrinhoDeCompras();
        this.pedidosRegistrados = new HashMap<>();
        this.precosTotais = new HashMap<>();
    }

    public void exibeProdutosDoCarrinho() {
        int totalProdutos = 0;
        for (Produto produto : this.carrinhoDeCompras.getComprasDoCarrinho()) {
            System.out.println(++totalProdutos + ". " + produto.getNome());
        }
    }
/*if (produto != null) {
        System.out.println("\n  " + opcaoAbrirDetalhes.toUpperCase() + "\n" + produto);
        System.out.print("Quer adicionar ao seu carrinho? [s/n] ");
        String simOuNao = scanner.nextLine();
        if (simOuNao.equals("s")) {
            cliente.adicionarNoCarrinho(produto);
            cliente.getCarrinhoDeCompras().fazPrecoTotalDoCarrinho();
        }
    }*/
    public void exibePrecoTotalDaCompra() { //trocar para metodo vindo do Pedido
        System.out.print(this.carrinhoDeCompras.getSaldoTotalDaCompra());
    }

    public void adicionarNoCarrinho(Produto produtoAdicionado) {
        this.carrinhoDeCompras.getComprasDoCarrinho().add(produtoAdicionado);
    }

    public boolean verificaEndereco() {
        return endereco != null;
    }

    public boolean verificaSaldo() {
        return saldoCliente != 0.0;
    }

    public boolean adicionaSaldo(float saldo) {
        if (saldo > 0) {
            this.saldoCliente += saldo;
            return true;
        }
        return false;
    }

    public void registraPedido () {
        List<Produto> listaDeProdutosDoCarrinho = this.carrinhoDeCompras.getComprasDoCarrinho();
        Pedido pedidoCriado = new Pedido(listaDeProdutosDoCarrinho);
        pedidosRegistrados.put(pedidoCriado.getCodigoDoPedido(), pedidoCriado);
        limpaCarrinho();
    }

    public void limpaCarrinho () {
        this.carrinhoDeCompras.getComprasDoCarrinho().clear();
    }

    public Map<Integer, Pedido> getPedidosRegistrados() {
        return pedidosRegistrados;
    }

    public Map<Integer, Float> getPrecosTotais() {
        return precosTotais;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getSaldoCliente() {
        return saldoCliente;
    }

    public CarrinhoDeCompras getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }


}