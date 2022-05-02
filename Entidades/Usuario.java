package Entidades;

public class Usuario {

    protected String nome;
    protected String login;
    protected String senha;
    protected int codigo;

    public Usuario (String nome, String login, String senha, int codigo) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.codigo = codigo;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}