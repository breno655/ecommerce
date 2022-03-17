package Entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ecommerce {

    public String nome = "Cyber Feira";
    private Map<Categoria, List<Produto>> dicionario;
    private List<Usuario> usuarios;

    public Ecommerce () {
        this.nome = nome;
        this.dicionario = new HashMap<>();
        this.usuarios = new ArrayList<>();
    }

    public Map<Categoria, List<Produto>> getDicionario() {
        return dicionario;
    }

    public void setDicionario(Map<Categoria, List<Produto>> dicionario) {
        this.dicionario = dicionario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


}
