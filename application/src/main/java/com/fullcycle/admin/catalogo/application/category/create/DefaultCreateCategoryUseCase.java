package com.fullcycle.admin.catalogo.application.category.create;

import com.fullcycle.admin.catalogo.domain.Category.Category;
import com.fullcycle.admin.catalogo.domain.Category.CategoryGateway;
import com.fullcycle.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.API;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {


    //sempre fazer injecao de dependencia via construtor para evitar dependencia ciclica

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Either<Notification, CreateCategoryOutput> execute(
            final CreateCategoryCommand aCommand) {

        final var aName = aCommand.name();
        final var aDescription = aCommand.description();
        final var isActive = aCommand.isActive();

        final var notification = Notification.create();

        final var aCategory = Category.newCategory(aCommand.name(), aCommand.description(), aCommand.isActive());
        aCategory.validate(notification);

        return notification.hasErrors() ? Left(notification) : create(aCategory);

    }

    private Either<Notification, CreateCategoryOutput> create(final Category aCategory) {
        Try(() -> categoryGateway.create(aCategory))
                .toEither()
                .bimap( Notification::create, CreateCategoryOutput::fromCategory);

       return API.Right(CreateCategoryOutput.fromCategory(this.categoryGateway.create(aCategory)));
    }
}
