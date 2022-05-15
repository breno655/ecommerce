package Entidades;
import enums.ProdutoEnum;

public class Produto {

    private String nome;
    private float preco;
    private String descricao;
    private int quantidade;
    private int codigoProduto;
    private ProdutoEnum status;

    public Produto(String nome, float preco, String descricao, int quantidade, int codigoProduto, ProdutoEnum status) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.codigoProduto = codigoProduto;
        this.status = status;
    }

    public Produto () {

    }

    public ProdutoEnum getStatus () {
        return status;

    }

    public ProdutoEnum alteraStatus (String novoStatus) {
        this.status = ProdutoEnum.valueOf(novoStatus);
        return status;
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

    public String toString () {
        return String.format("      Nome: %s\n", nome)
                + String.format("      Preço: R$%.2f\n", preco)
                + String.format("      Descrição: %s\n", descricao);
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
}
