package com.desafio.produtosapi.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//POJO -> plain old java Object
@Entity
@Table (name = "produto")
public class Produto {

    @Id
    @Column(name = "id")// caso for necessarios fazer mapeamento com nome da coluna com nome diferente
    private String id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Double preco;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome= '" + nome + '\'' +
                ", descricao= '" + descricao + '\'' +
                ", preço= " + preco +
                '}';
    }
}
