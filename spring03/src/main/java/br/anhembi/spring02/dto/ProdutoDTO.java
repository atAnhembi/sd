package br.anhembi.spring02.dto;

import br.anhembi.spring02.model.Produto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoDTO {
    @NotNull(message = "O nome é um campo obrigatório")
    @NotBlank(message = "O nome não pode ser deixado em branco")
    private String name;
    @Min(value = 1)
    private double price;

    @Email(message = "O email deve ser válido")
    private String email;

    public Produto toProduto() {
        return new Produto(null, name, price, null);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
