package com.github.jbarseg.persistence.entity;

import org.springframework.web.servlet.FlashMapManager;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class ProductPurchase {

    @EmbeddedId
    private ProductPurchasePK id;

    @Column(name = "cantidad")
    private int amount;
    @Column(name = "total")
    private Double total;
    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    Product product;

    public ProductPurchasePK getId() {
        return id;
    }
    public void setId(ProductPurchasePK id) {
        this.id = id;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "ProductPurchase [id=" + id + ", amount=" + amount + ", total=" + total + ", status=" + status + "]";
    }
}
