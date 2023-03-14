package com.github.jbarseg.domain;

public class ProductDomain {

    private int productDomainId;
    private String productDomainName;
    private int categoryDomainId;
    private double price;
    private int productStock;
    private boolean active;
    //In terms of our domain
    private CategoryDomain categoryDomain;
    public int getProductDomainId() {
        return productDomainId;
    }
    public void setProductDomainId(int productDomainId) {
        this.productDomainId = productDomainId;
    }

    public String getProductDomainName() {
        return productDomainName;
    }

    public void setProductDomainName(String productDomainName) {
        this.productDomainName = productDomainName;
    }

    public int getCategoryDomainId() {
        return categoryDomainId;
    }
    public void setCategoryDomainId(int categoryDomainId) {
        this.categoryDomainId = categoryDomainId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public CategoryDomain getCategoryDomain() {
        return categoryDomain;
    }
    public void setCategoryDomain(CategoryDomain categoryDomain) {
        this.categoryDomain = categoryDomain;
    }
}
