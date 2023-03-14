package com.github.jbarseg.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.github.jbarseg.persistence.entity.Product;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Product> findByIdCategoryOrderByNameAsc (int idCategory);
    Optional<List<Product>> findByStockLessThanAndStatus (int stock, boolean status);
    
}
