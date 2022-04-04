package Entidades;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Produto> carrinhoDeCompras;
    private float saldoTotalDaCompra;
    private Cliente cliente;

    public CarrinhoDeCompras () {
        this.carrinhoDeCompras = new ArrayList<>();
        this.saldoTotalDaCompra = 0;
    }

    public void fazPrecoTotalDoCarrinho () {
        float precoTotalDaCompra = 0;
        for (Produto produto : carrinhoDeCompras) {
            precoTotalDaCompra += produto.getPreco();
        }
        saldoTotalDaCompra = precoTotalDaCompra;
    }

    public List<Produto> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(List<Produto> carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

    public float getSaldoTotalDaCompra() {
        return saldoTotalDaCompra;
    }

    public void setSaldoTotalDaCompra(float saldoTotalDaCompra) {
        this.saldoTotalDaCompra = saldoTotalDaCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
