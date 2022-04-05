package Entidades;

public class Cliente extends Usuario {

    final int codigoCliente = 1;
    private CarrinhoDeCompras carrinhoDeCompras;
    private String endereco;
    private float saldo;

    public Cliente () {

    }

    public Cliente (String nome, String login, String senha) {
        super(nome, login, senha);
        this.carrinhoDeCompras = new CarrinhoDeCompras();
    }

    public void exibeProdutosDoCarrinho () {
        int totalProdutos = 0;
        for (Produto produto : carrinhoDeCompras.getCarrinhoDeCompras()) {
            System.out.println(++totalProdutos + ". " + produto.getNome());
        }
    }

    public void exibePrecoTotalDaCompra () {
        System.out.print(carrinhoDeCompras.getSaldoTotalDaCompra());
    }

    public void adicionarNoCarrinho (Produto produtoAdicionado) {
        carrinhoDeCompras.getCarrinhoDeCompras().add(produtoAdicionado);
    }

    public boolean vericaEndereco () {
        return endereco != null;
    }

    public boolean vericaSaldo () {
        return saldo != 0.0;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public CarrinhoDeCompras getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }
}
