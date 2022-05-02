package Entidades;

public class Cliente extends Usuario {

    private CarrinhoDeCompras carrinhoDeCompras;
    private String endereco;
    private float saldoCliente;
    private Pedido pedidos;

    public Cliente() {

    }

    public Cliente(String nome, String login, String senha, int codigo) {
        super(nome, login, senha, codigo);
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.codigo = 1;
        this.carrinhoDeCompras = new CarrinhoDeCompras();
    }


    public void exibeProdutosDoCarrinho() {
        int totalProdutos = 0;
        for (Produto produto : carrinhoDeCompras.getCarrinhoDeCompras()) {
            System.out.println(++totalProdutos + ". " + produto.getNome());
        }
    }

    public void exibePrecoTotalDaCompra() {
        System.out.print(carrinhoDeCompras.getSaldoTotalDaCompra());
    }

    public void adicionarNoCarrinho(Produto produtoAdicionado) {
        carrinhoDeCompras.getCarrinhoDeCompras().add(produtoAdicionado);
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

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

}