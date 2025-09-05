package com.fullcycle.admin.catalogo.domain.Category;

import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {

        //criacao de teste baseado em TDD, garantindo que o métod0 seja implementado após o teste.

        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedActive);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertNotNull( actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());

    }@Test
    public void givenAInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {

        //criacao de teste baseado em TDD, garantindo que o métod0 seja implementado após o teste.

        final String expectedName = null;
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedErrorCount = 1;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());

    }


}