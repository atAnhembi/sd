package br.anhembi.spring02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity // armazena no BD
public class Produto {
    @Id // esse atributo é PK no BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //1,2,3,4...
    private Long cod;
    
    private String name;
    private double price;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Fornecedor fornecedor;

    public Produto() {
    }


    public Produto(Long cod, String name, double price, Fornecedor fornecedor) {
        this.cod = cod;
        this.name = name;
        this.price = price;
        this.fornecedor = fornecedor;
    }

    public Long getCod() {
        return cod;
    }
    public void setCod(Long cod) {
        this.cod = cod;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    

}
