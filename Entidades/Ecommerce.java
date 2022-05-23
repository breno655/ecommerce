package Entidades;

import java.util.*;

public class Ecommerce {

    public String nome;
    private Map<String, Categoria> dicionario;
    private Map<Integer, Produto> todosOsProdutosDoEcommerce;
    private Map<String, Usuario> usuarios;

    public Ecommerce() {
        this.nome = "Cyber Feira";
        this.dicionario = new HashMap<>();
        this.todosOsProdutosDoEcommerce = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    public void exibeUsuarios (int tipoUsuario) {
        for (Usuario usuario : usuarios.values()) {
            if (usuario.codigo == tipoUsuario) {
                System.out.println("- " + usuario.getNome().toUpperCase());
            }
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

    public void removeProduto (Produto produto) {
        String key = produto.getNome();
        usuarios.remove(key);
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
        for (Categoria categoria : categoria1.getSubcategorias()) {
            if (categoria.getNome().equals(nomeCategoria)) {
                return categoria;
            }
        }
        return categoria1;
    }

    public Produto buscarProdutos (String produtoBuscado) {
        for (Produto produto : getTodosOsProdutosDoEcommerce().values()) {
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

    public Categoria achaCategoriaAcima (Categoria categoriaFilho) {
        for (Categoria categoriaPai : dicionario.values()) {
            if (categoriaPai.getSubcategorias().contains(categoriaFilho)){
                return categoriaPai;
            }
        } return categoriaFilho;
    }

    public boolean verificaLogin(String loginDoUsuario, String senhaUsuario, int codigoUsuario) {
        boolean validado = false;
        for (Usuario usuario : usuarios.values()) {
            if (usuario.login.equals(loginDoUsuario) && usuario.senha.equals(senhaUsuario) && usuario.codigo == codigoUsuario) {
                validado = true;
                break;
            }
        }
        return validado;
    }


    public void cadastro (int codigo, String nomeUsuario, String loginUsuario, String senhaUsuario, Ecommerce ecommerce) {
        if (codigo == 1) {
            Cliente cliente = new Cliente(nomeUsuario, loginUsuario, senhaUsuario, codigo);
            ecommerce.getUsuarios().put(loginUsuario, cliente);
        } else if (codigo == 2) {
            System.out.println("Não pode ser criado mais de um ADMINISTRADOR");
        } else if (codigo == 3) {
            Vendedor vendedor = new Vendedor(nomeUsuario, loginUsuario, senhaUsuario, codigo );
            ecommerce.getUsuarios().put(loginUsuario, vendedor);
        }
    }

    public boolean login (String loginUsuario, String senhaUsuario, int codigo, Ecommerce ecommerce) {
        if ((!ecommerce.verificaLogin(loginUsuario, senhaUsuario, codigo))) {
            System.out.println("\nUsuário e/ou senha estão errados.\nTente novamente.\n");
            return false;
        }
        return true;
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

    public Map<Integer, Produto> getTodosOsProdutosDoEcommerce() {
        return todosOsProdutosDoEcommerce;
    }

    public void setTodosOsProdutosDoEcommerce(Map<Integer, Produto> todosOsProdutosDoEcommerce) {
        this.todosOsProdutosDoEcommerce = todosOsProdutosDoEcommerce;
    }
}