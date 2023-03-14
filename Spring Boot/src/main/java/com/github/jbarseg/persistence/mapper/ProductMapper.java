package com.github.jbarseg.persistence.mapper;

import java.util.List;

import com.github.jbarseg.persistence.entity.Category;
import org.mapstruct.*;

import com.github.jbarseg.domain.ProductDomain;
import com.github.jbarseg.persistence.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    String map(Category value);

    @Mappings({
        @Mapping(source = "idProduct", target = "productDomainId"),
        @Mapping(source = "name", target = "productDomainName"),
        @Mapping(source = "idCategory", target = "categoryDomainId"),
        @Mapping(source = "salePrice", target = "price"),
        @Mapping(source = "stock", target = "productStock"),
        @Mapping(source = "status", target = "active"),
        @Mapping(source = "category", target = "categoryDomain"),
    })

    ProductDomain toDomainProduct (Product product);
    List<ProductDomain> toDomainProducts(List<Product>products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct (ProductDomain productDomain);

    @Named("mapCategoryToString")
    default String mapCategoryToString(Category category) {
        return category.getDescription();
    }
}
