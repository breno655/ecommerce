package Entidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {

    
    private Map<Integer, Float> precosTotais;
    private Map<Integer, List<Produto>> pedidosRegistrados;

    public Pedido () {
        this.pedidosRegistrados = new HashMap<>();
    }

    public void registraPedido (Cliente cliente) {
        int numeroRegistro = 0;
        pedidosRegistrados.put(++numeroRegistro, cliente.getCarrinhoDeCompras().getCarrinhoDeCompras());
    }

    public void calculaPrecoDoPedido () {
        float precoTotalDaCompra = 0;
        int indice = 0;
        for (List<Produto> produtos : pedidosRegistrados.values()) {
            for (Produto produto : produtos) {
                precoTotalDaCompra += produto.getPreco();
            }
            precosTotais.put(++indice, precoTotalDaCompra);
        }
    }

    public Map<Integer, List<Produto>> getPedidosRegistrados() {
        return pedidosRegistrados;
    }

    public void setPedidosRegistrados(Map<Integer, List<Produto>> pedidosRegistrados) {
        this.pedidosRegistrados = pedidosRegistrados;
    }

    public Map<Integer, Float> getPrecosTotais() {
        return precosTotais;
    }

    public void setPrecosTotais(Map<Integer, Float> precosTotais) {
        this.precosTotais = precosTotais;
    }
}
