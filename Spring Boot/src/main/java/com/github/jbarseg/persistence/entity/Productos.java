package com.github.jbarseg.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProduct;
    @Column(name = "id_categoria")
    private int idCategory;
    @Column(name = "cantidad_stock")
    private int stock;
    @Column(name = "precio_venta")
    private Double salePrice;
    @Column(name = "codigo_barras")
    private String barCode;
    @Column(name = "nombre")
    private String name;
    @Column(name = "estado")
    private Boolean status;

    public Productos() {
    }

    

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Productos [idProduct=" + idProduct + ", idCategory=" + idCategory + ", stock=" + stock + ", salePrice="
                + salePrice + ", barCode=" + barCode + ", name=" + name + ", status=" + status + "]";
    }

}
