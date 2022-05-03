package Entidades;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Produto> comprasDoCarrinho;
    private float saldoTotalDaCompra;

    public CarrinhoDeCompras () {
        this.comprasDoCarrinho = new ArrayList<>();
        this.saldoTotalDaCompra = 0;
    }

    public boolean verificaSaldoSuficienteParaCompra (Cliente cliente) {
        return cliente.getSaldoCliente() >= saldoTotalDaCompra;
    }

    public void fazPrecoTotalDoCarrinho () {
        float precoTotalDaCompra = 0;
        for (Produto produto : comprasDoCarrinho) {
            precoTotalDaCompra += produto.getPreco();
        }
        saldoTotalDaCompra = precoTotalDaCompra;
    }

    public List<Produto> getComprasDoCarrinho() {
        return comprasDoCarrinho;
    }

    public float getSaldoTotalDaCompra() {
        return saldoTotalDaCompra;
    }

    public void setSaldoTotalDaCompra(float saldoTotalDaCompra) {
        this.saldoTotalDaCompra = saldoTotalDaCompra;
    }
}
