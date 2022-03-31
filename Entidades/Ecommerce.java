package Entidades;

import java.util.*;

public class Ecommerce {

    Scanner scanner = new Scanner(System.in);

    public String nome = "Cyber Feira";
    private Map<Categoria, List<Categoria>> dicionario;
    private List<Produto> produtos;
    private Map<String, Usuario> usuarios;

    public Ecommerce () {
        this.nome = nome;
        this.dicionario = new HashMap<>();
        this.produtos = new ArrayList<>();
        this.usuarios = new HashMap<>();
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

    public void imprimirDicionario () {
        int contadorCategoria = 0; int contadorSubcategoria = 0; int contadorProduto = 0;

        for (Categoria key : dicionario.keySet()) {
            System.out.println(++contadorCategoria + ". " + key.getNome());
            for (Categoria subcategorias : key.getSubcategorias()) {
                System.out.println("   " + ++contadorSubcategoria + ". " + subcategorias.getNome());
                for (Produto produto : subcategorias.getProdutos()) {
                    System.out.println("     " + ++contadorProduto + ". " + produto.getNome());
                }
            }
        }
    }

    public Map<Categoria, List<Categoria>> getDicionario() {
        return dicionario;
    }

    public void setDicionario(Map<Categoria, List<Categoria>> dicionario) {
        this.dicionario = dicionario;
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
}
