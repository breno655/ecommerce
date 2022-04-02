package Entidades;

import java.util.*;

public class Ecommerce {

    Scanner scanner = new Scanner(System.in);

    public String nome = "Cyber Feira";
    private Map<String, Categoria> dicionario;
    private List<Produto> produtos;
    private Map<String, Usuario> usuarios;

    public Ecommerce () {
        this.nome = nome;
        this.dicionario = new HashMap<>();
        this.produtos = new ArrayList<>();
        this.usuarios = new HashMap<>();
    }

    public void exibeDicionario (Categoria categoria) {

    }

    public void exibeCategorias () {
        for (String nomeCategoria : dicionario.keySet()) {
            System.out.println("- " + nomeCategoria.toUpperCase());
        }
    }

    public Categoria escolheCategoria (String nomeCategoria) {
        for (Categoria categoria : dicionario.values()) {
            if (categoria.getNome().equals(nomeCategoria)) {
                return categoria;
            }
        } return null;
    }

    public boolean buscarUsuario (String loginDoUsuario) {
        boolean encontrado = false;
        for (String login : usuarios.keySet()) {
            if (login.equals(loginDoUsuario)) {
                encontrado = true;
                break;
            }
        } return encontrado;
    }

    public boolean verficaLogin (String loginDoUsuario, String senhaUsuario) {
        boolean validado = false;
        for (Usuario usuario : usuarios.values()) {
            if (usuario.login.equals(loginDoUsuario) && usuario.senha.equals(senhaUsuario)) {
                validado = true;
                break;
            }
        } return validado;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Map<String, Categoria> getDicionario() {
        return dicionario;
    }

    public void setDicionario(Map<String, Categoria> dicionario) {
        this.dicionario = dicionario;
    }
}
