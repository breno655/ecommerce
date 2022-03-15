package ProjectEcomerce;

import Entidades.Categoria;
import Entidades.Produto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ecommerce {

    public String nome = "Cyber Feira";
    private Map<Categoria, List<Produto>> dicionario;

    public Ecommerce () {
        this.nome = nome;
        this.dicionario = new HashMap<>();
    }

    public Map<Categoria, List<Produto>> getDicionario() {
        return dicionario;
    }

    public void setDicionario(Map<Categoria, List<Produto>> dicionario) {
        this.dicionario = dicionario;
    }
}
