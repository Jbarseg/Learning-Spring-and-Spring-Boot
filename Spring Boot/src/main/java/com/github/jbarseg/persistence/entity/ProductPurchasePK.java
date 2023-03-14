package com.github.jbarseg.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductPurchasePK implements Serializable {

    @Column(name = "id_compra")
    private Integer idPurchase;
    @Column(name = "id_producto")
    private Integer idProduct;

    public Integer getIdPurchase() {
        return idPurchase;
    }
    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }
    public Integer getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

}
