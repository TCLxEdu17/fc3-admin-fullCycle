package com.fullcycle.admin.catalogo.application.category.create;

import com.fullcycle.admin.catalogo.domain.Category.Category;
import com.fullcycle.admin.catalogo.domain.Category.CategoryGateway;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {


    //sempre fazer injecao de dependencia via construtor para evitar dependencia ciclica

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public CreateCategoryOutput execute(final CreateCategoryCommand aCommand) {

        final var aCategory = Category.newCategory(aCommand.name(), aCommand.description(), aCommand.isActive());

        return CreateCategoryOutput.fromCategory(categoryGateway.create(aCategory));

    }
}
