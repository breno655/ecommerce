package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    final int codigoCliente = 1;
    private List<Produto> carrinhoDeProduto;

    public Cliente () {

    }

    public Cliente (String nome, String login, String senha) {
        super(nome, login, senha);
        this.carrinhoDeProduto = new ArrayList<>();
    }

    public List<Produto> getCarrinhoDeProduto() {
        return carrinhoDeProduto;
    }

    public void setCarrinhoDeProduto(List<Produto> carrinhoDeProduto) {
        this.carrinhoDeProduto = carrinhoDeProduto;
    }
}
