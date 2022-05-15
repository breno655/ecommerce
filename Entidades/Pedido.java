package Entidades;

import enums.PedidoEnum;
import enums.ProdutoEnum;

import java.util.List;
import java.util.Random;

public class Pedido {

    private double precoTotalDoPedido;
    private List<Produto> produtosDoPedido;
    private int codigoDoPedido;
    private PedidoEnum statusPedido;

    Random gerador = new Random();

    public Pedido(List<Produto> produtosDoPedido) {
        this.produtosDoPedido = produtosDoPedido;
        this.codigoDoPedido = gerador.nextInt(10000);
    }

    public PedidoEnum getStatusPedido() {
        return statusPedido;
    }

    public PedidoEnum alteraStatusPedido(String novoStatusPedido) {
        this.statusPedido = PedidoEnum.valueOf(novoStatusPedido);
        return statusPedido;
    }

    public void calculaPrecoDoPedido() {
        double soma = 0.0;
        for (Produto produto : produtosDoPedido) {
            soma += produto.getPreco();
        }
        precoTotalDoPedido = soma;
    }

    public double getPrecoTotalDoPedido() {
        return precoTotalDoPedido;
    }

    public void setPrecoTotalDoPedido(double precoTotalDoPedido) {
        this.precoTotalDoPedido = precoTotalDoPedido;
    }

    public List<Produto> getProdutosDoPedido() {
        return produtosDoPedido;
    }

    public void setProdutosDoPedido(List<Produto> produtosDoPedido) {
        this.produtosDoPedido = produtosDoPedido;
    }

    public int getCodigoDoPedido() {
        return codigoDoPedido;
    }

    public void setCodigoDoPedido(int codigoDoPedido) {
        this.codigoDoPedido = codigoDoPedido;
    }
}
