package org.example.pwt_lab6.Classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;
    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<Invoice> invoices;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
