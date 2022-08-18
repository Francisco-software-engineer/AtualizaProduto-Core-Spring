package br.com.devencer.update.core.domain.entity;

import br.com.devencer.update.core.domain.rules.Product_Rules;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class Product implements Comparable<Product>, Serializable {
    private int id;
    private String barcode;
    private String description;
    private BigDecimal price;
    @Setter
    private Rule rules = Product_Rules.DEFAULT.getRule();

    public Product(int id, String barcode, String description, BigDecimal price) {
        this.id = id;
        this.barcode = barcode;
        this.description = description;
        this.price = price;
    }

    @Override
    public int compareTo(Product anotherProduct) {
        return rules.compareTo(this, anotherProduct);
    }

    @Override
    public boolean equals(Object o) {
        return rules.equals(this, (Product) o);
    }

    @Override
    public int hashCode() {
        return rules.hashCode(this);
    }
}
