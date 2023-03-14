package com.github.jbarseg.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.github.jbarseg.domain.CategoryDomain;
import com.github.jbarseg.persistence.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
        @Mapping(source = "idCategory", target = "categoryDomainId"),
        @Mapping(source = "description", target = "category"),
        @Mapping(source = "status", target = "active"),
    })
    CategoryDomain toCategory (Category category);
    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory (CategoryDomain category);
}