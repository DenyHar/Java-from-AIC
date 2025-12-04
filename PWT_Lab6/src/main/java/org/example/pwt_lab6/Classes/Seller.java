package org.example.pwt_lab6.Classes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper=true)
@SuperBuilder
@NoArgsConstructor
public class Seller extends Person{
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<Invoice> invoices;

}
