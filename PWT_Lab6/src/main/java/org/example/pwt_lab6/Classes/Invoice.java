package org.example.pwt_lab6.Classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer buyer;

    private LocalDate date;

    public Invoice(Product product, Seller seller, Buyer buyer, LocalDate date) {
        this.product = product;
        this.seller = seller;
        this.buyer = buyer;
        this.date = date;
    }

    public String toString()
    {
        return "Продукт: " + (product != null ? product.getName() + " Ціна: " + product.getPrice() : null)  + "; Продавець: " + (seller != null ? seller.getLastName() : null)  + "; Покупець: " + (buyer != null ? buyer.getLastName() : null) + "; Дата: " + date.toString();
    }
}
