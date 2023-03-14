package com.github.jbarseg.domain;

public class CategoryDomain {
    private int categoryDomainId;
    private String category;
    private boolean active;
    
    public int getCategoryDomainId() {
        return categoryDomainId;
    }
    public void setCategoryDomainId(int categoryDomainId) {
        this.categoryDomainId = categoryDomainId;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    @Override
    public String toString() {
        return "CategoryDomain [categoryDomainId=" + categoryDomainId + ", category=" + category + ", active=" + active
                + "]";
    }
}
