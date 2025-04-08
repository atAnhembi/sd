package br.anhembi.spring02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // armazena no BD
public class Produto {
    @Id // esse atributo é PK no BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //1,2,3,4...
    private Long cod;
    private String name;
    private double price;

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
}
