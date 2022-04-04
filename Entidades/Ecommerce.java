package Entidades;

import java.util.*;

public class Ecommerce {

    Scanner scanner = new Scanner(System.in);

    public String nome = "Cyber Feira";
    private Map<String, Categoria> dicionario;
    private List<Produto> todosOsProdutosDoEcommerce;
    private Map<String, Usuario> usuarios;

    public Ecommerce() {
        this.nome = nome;
        this.dicionario = new HashMap<>();
        this.todosOsProdutosDoEcommerce = new ArrayList<>();
        this.usuarios = new HashMap<>();
    }

    public void exibeUsuarios () {
        for (Usuario usuario : usuarios.values()) {
            System.out.println("- " + usuario.getNome().toUpperCase());
        }
    }

    public void exibeSubCats(Categoria categoria) {
        for (Categoria subCats : categoria.getSubcategorias()) {
            System.out.println("- " + subCats.getNome().toUpperCase());
        }
    }

    public void exibeCategorias() {
        for (String nomeCategoria : dicionario.keySet()) {
            System.out.println("- " + nomeCategoria.toUpperCase());
        }
    }

    public Usuario escolheUsuarios(String opcaoUsuario) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getNome().equals(opcaoUsuario)) {
                return usuario;
            }
        }
        return null;
    }
    public Categoria escolheCategoria(String nomeCategoria) {
        Categoria categoriaReturn = new Categoria();
        for (Categoria categoria : dicionario.values()) {
            if (categoria.getNome().equals(nomeCategoria)) {
                categoriaReturn = categoria;
            }
        }
        return categoriaReturn;
    }

    public Categoria escolheSubCat(String nomeCategoria, Categoria categoria1) {
        Categoria categoriaReturn = null;
        for (Categoria categoria : categoria1.getSubcategorias()) {
            if (categoria.getNome().equals(nomeCategoria)) {
                categoriaReturn = categoria;
            }
        }
        return categoriaReturn;
    }

    public Produto buscarProdutos (String produtoBuscado) {
        for (Produto produto : todosOsProdutosDoEcommerce) {
            if (produto.getNome().equals(produtoBuscado)) {
                return produto;
            }
        } return null;
    }

    public Usuario buscarUsuario(String loginDoUsuario) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getLogin().equals(loginDoUsuario)) {
                return usuario;
            }
        } return null;
    }

    public boolean verficaLogin(String loginDoUsuario, String senhaUsuario) {
        boolean validado = false;
        for (Usuario usuario : usuarios.values()) {
            if (usuario.login.equals(loginDoUsuario) && usuario.senha.equals(senhaUsuario)) {
                validado = true;
                break;
            }
        }
        return validado;
    }

    public void cadastro (int tipoDeUsuario, String nomeUsuario, String loginUsuario, String senhaUsuario, Ecommerce ecommerce) {
        if (tipoDeUsuario == 1) {
            Cliente cliente = new Cliente(nomeUsuario, loginUsuario, senhaUsuario);
            ecommerce.getUsuarios().put(loginUsuario, cliente);
        } else if (tipoDeUsuario == 2) {
            System.out.println("Não pode ser criado mais de um ADMINISTRADOR");
        } else if (tipoDeUsuario == 3) {
            Vendedor vendedor = new Vendedor(nomeUsuario, loginUsuario, senhaUsuario);
            ecommerce.getUsuarios().put(loginUsuario, vendedor);
        }
    }

    public boolean login (String loginUsuario, String senhaUsuario, Ecommerce ecommerce) {
        if ((!ecommerce.verficaLogin(loginUsuario, senhaUsuario))) {
            System.out.println("Não existe ou foi digitado errado");
            return false;
        }
        return true;
    }

    public List<Produto> getTodosOsProdutosDoEcommerce() {
        return todosOsProdutosDoEcommerce;
    }

    public void setTodosOsProdutosDoEcommerce(List<Produto> produtos) {
        this.todosOsProdutosDoEcommerce = produtos;
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
