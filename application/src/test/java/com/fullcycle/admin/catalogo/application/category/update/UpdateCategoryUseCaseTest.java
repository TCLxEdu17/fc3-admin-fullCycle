package com.fullcycle.admin.catalogo.application.category.update;


import com.fullcycle.admin.catalogo.domain.Category.Category;
import com.fullcycle.admin.catalogo.domain.Category.CategoryGateway;
import com.fullcycle.admin.catalogo.domain.Category.CategoryID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static net.bytebuddy.utility.JavaModule.of;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateCategoryUseCaseTest {

    @InjectMocks
    private DefaultUpdateCategoryUseCase useCase;

    private CategoryGateway categoryGateway;

    @Test
    public void givenAValidCommand_whenUpdateCategoryUseCase_thenReturnCategory() {

        final var aCategory =  Category.newCategory("nam", null, true);
        final var expectedId = aCategory.getId().getValue();
        final var expectedName = "name";
        final var expectedDescription = "description";
        final boolean expectedIsActive = true;

        final var aCommand = UpdateCategoryCommand.with(
                expectedId,
                expectedName,
                expectedDescription,
                expectedIsActive
        );

        when(categoryGateway.findById(CategoryID.from(Mockito.eq(expectedId))
                .)
                (of(aCategory));

    }
}
