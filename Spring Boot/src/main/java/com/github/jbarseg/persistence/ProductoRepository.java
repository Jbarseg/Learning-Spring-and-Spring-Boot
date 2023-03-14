package com.github.jbarseg.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.jbarseg.domain.ProductDomain;
import com.github.jbarseg.domain.repository.ProductRepository;
import com.github.jbarseg.persistence.crud.ProductCrudRepository;
import com.github.jbarseg.persistence.entity.Product;
import com.github.jbarseg.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDomain> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return productMapper.toDomainProducts(products);
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory (int idCategory){
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(productMapper.toDomainProducts(products));
    }

    @Override
    public Optional<List<ProductDomain>> getScarseProducts(int quantity){
        Optional <List<Product>> products = productCrudRepository.findByStockLessThanAndStatus(quantity, true);
        return products.map(prods -> productMapper.toDomainProducts(prods));
    }

    @Override
    public Optional<ProductDomain> getProduct(int idProduct){
        return productCrudRepository.findById(idProduct).map(product -> productMapper.toDomainProduct(product));
    }

    @Override
    public ProductDomain save (ProductDomain productDomain){
        Product product = productMapper.toProduct(productDomain);
        return productMapper.toDomainProduct(productCrudRepository.save(product));
    }

    @Override
    public void delete (int idProduct){
        productCrudRepository.deleteById(idProduct);
    }

}
