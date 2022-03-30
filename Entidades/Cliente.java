package Entidades;

public class Cliente extends Usuario {

    final int codigoCliente = 1;

    public Cliente () {

    }

    public Cliente (String nome, String login, String senha) {
        super(nome, login, senha);
    }

}
