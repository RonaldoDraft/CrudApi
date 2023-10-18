package com.example.Spring.boot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "TB_PRODUCTS")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idproduct;
    private String name;
    private BigDecimal value;


}
