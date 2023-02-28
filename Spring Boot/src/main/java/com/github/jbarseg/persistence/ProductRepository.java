package com.github.jbarseg.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.jbarseg.persistence.crud.ProductCrudRepository;
import com.github.jbarseg.persistence.entity.Product;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;
    public List<Product> getAll(Product product){
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory (int idCategory){
        return productCrudRepository.findByIdCategoryOrderByNombreAsc(idCategory);
    }

    public Optional<List<Product>> getLessThan(int stock){
        return productCrudRepository.findByStockLessThanAndStatus(stock, true);
    }

    public Optional<Product> getProduct(int idProduct){
        return productCrudRepository.findById(idProduct);
    }

    public Product save (Product product){
        return productCrudRepository.save(product);
    }

    public void delete (int idProduct){
        productCrudRepository.deleteById(idProduct);
    }
}
