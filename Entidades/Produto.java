package Entidades;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Produto {

    private String nome;
    private float preco;
    private String descricao;
    private int quantidade;

    Scanner scanner = new Scanner(System.in);

    public Produto (String nome, float preco, String descricao, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Produto () {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toStringCliente () {
        return String.format("      Nome: %s\n", nome)
                + String.format("      Preço: R$%.2f\n", preco)
                + String.format("      Descrição: %s\n", descricao);
    }

    public String toStringVendedor () {
        return String.format("      Nome: %s\n", nome)
                + String.format("      Preço: R$%.2f\n", preco)
                + String.format("      Descrição: %s\n", descricao)
                + String.format("      Quantidade: %s\n", quantidade);
    }

}
