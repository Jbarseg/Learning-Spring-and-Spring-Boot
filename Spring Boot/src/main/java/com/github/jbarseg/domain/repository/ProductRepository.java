package com.github.jbarseg.domain.repository;

import java.util.List;
import java.util.Optional;

import com.github.jbarseg.domain.ProductDomain;

public interface ProductRepository {
    List<ProductDomain> getAll();
    Optional<List<ProductDomain>> getByCategory(int categoryDomainId);
    Optional<List<ProductDomain>> getScarseProducts(int quantity);
    Optional<ProductDomain> getProduct(int productDomainId);
    ProductDomain save (ProductDomain productDomain);
    void delete (int productDomainId);
}
