package com.github.jbarseg.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jbarseg.domain.ProductDomain;
import com.github.jbarseg.domain.repository.ProductRepository;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDomain> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<ProductDomain>> getByCategory (int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public ProductDomain save(ProductDomain productDomain){
        return productRepository.save(productDomain);
    }

    public Optional<ProductDomain> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public boolean delete (int productId){
        if (getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }
    }

}
