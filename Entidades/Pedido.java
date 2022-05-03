package Entidades;

import java.util.List;
import java.util.Random;

public class Pedido {

    private Double precoTotalDoPedido;
    private List<Produto> produtosDoPedido;
    private int codigoDoPedido;

    Random gerador = new Random();

    public Pedido (List<Produto> produtosDoPedido) {
        this.produtosDoPedido = produtosDoPedido;
        this.codigoDoPedido = gerador.nextInt(10000);
    }

    public void calculaPrecoDoPedido () {
        double soma = 0.0;
        for (Produto produto : produtosDoPedido) {
            soma += produto.getPreco();
        }
        precoTotalDoPedido = soma;
    }

    public Double getPrecoTotalDoPedido() {
        return precoTotalDoPedido;
    }

    public void setPrecoTotalDoPedido(Double precoTotalDoPedido) {
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
