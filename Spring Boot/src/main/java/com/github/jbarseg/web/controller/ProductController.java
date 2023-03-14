package com.github.jbarseg.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jbarseg.domain.ProductDomain;
import com.github.jbarseg.domain.service.ProductService;

@RestController
@RequestMapping("jbarseg-market/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<ProductDomain> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<ProductDomain> getProduct (@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<ProductDomain>> getByCategory (@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public ProductDomain save(@RequestBody ProductDomain productDomain){
        return productService.save(productDomain);
    }

    @DeleteMapping("/delete/{productId}")
    public boolean delete (@PathVariable("productId") int productId){
        return productService.delete(productId);
    }
}
