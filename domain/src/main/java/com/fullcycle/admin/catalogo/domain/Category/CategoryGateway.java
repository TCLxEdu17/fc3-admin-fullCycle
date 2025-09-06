package com.fullcycle.admin.catalogo.domain.Category;

import com.fullcycle.admin.catalogo.domain.pagination.Pagination;

import java.util.Optional;

public interface CategoryGateway {

    Category create(Category category);

    Optional<Category> findById(CategoryID id);

    void deleteById(CategoryID categoryID);

    Category update(Category category);

    Pagination<Category> findAll(CategorySearchQuery aQuery);


}
