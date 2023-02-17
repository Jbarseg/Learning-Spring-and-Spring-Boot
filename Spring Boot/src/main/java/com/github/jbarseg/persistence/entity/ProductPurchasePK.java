package com.github.jbarseg.persistence.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.CodePointLength;

import jakarta.persistence.Column;

public class ProductPurchasePK implements Serializable {

    @Column(name = "id_compra")
    private int idPurchase;
    @Column(name = "id_producto")
    private int idProduct;
}
