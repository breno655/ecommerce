package Entidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {

    private String status;
    private Map<Integer, List<Produto>> pedidosRegistrados;

    public Pedido () {
        this.status = "Pedido Enviado";
        this.pedidosRegistrados = new HashMap<>();
    }

    public void registraPedido (Cliente cliente) {
        int numeroRegistro = 0;
        pedidosRegistrados.put(++numeroRegistro, cliente.getCarrinhoDeCompras().getCarrinhoDeCompras());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<Integer, List<Produto>> getPedidosRegistrados() {
        return pedidosRegistrados;
    }

    public void setPedidosRegistrados(Map<Integer, List<Produto>> pedidosRegistrados) {
        this.pedidosRegistrados = pedidosRegistrados;
    }
}
