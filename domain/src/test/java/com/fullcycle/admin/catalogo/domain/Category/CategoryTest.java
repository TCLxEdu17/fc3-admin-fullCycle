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

    }

    @Test
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


    @Test
    public void givenAInvalidEmptyName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {

        //criacao de teste baseado em TDD, garantindo que o métod0 seja implementado após o teste.

        final String blankName = " " ;
        final var expectedErrorMessage = "'name' should not be empty";
        final var expectedErrorCount = 1;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        final var actualCategory =
                Category.newCategory(blankName, expectedErrorMessage, expectedActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());

    }

    @Test
    public void givenAInvalidNameLenghtLessThan3_whenCallNewCategoryAndValidate_thenShouldReceiveError() {

        //criacao de teste baseado em TDD, garantindo que o métod0 seja implementado após o teste.

        final String blankName = "Fi " ;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' must be between 3 and 255 characters ";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        final var actualCategory =
                Category.newCategory(blankName, expectedErrorMessage, expectedActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());

    }

    @Test
    public void givenAInvalidNameLenghtMoreThan255_whenCallNewCategoryAndValidate_thenShouldReceiveError() {

        //criacao de teste baseado em TDD, garantindo que o métod0 seja implementado após o teste.

        final var blankName = """
                 Assim mesmo, a necessidade de renovação processual representa uma abertura para a melhoria da l
                ógica predominante nas decisões estratégicas. Evidentemente, a gestão eficiente dos recursos estratégicos assume importantes
                 posições no estabelecimento do remanejamento dos quadros funcionais. 
                 O cuidado em identificar pontos críticos na análise aprofundada dos indicadores-chave
                  ainda não demonstrou convincentemente que vai participar na mudança da fluidez dos
                   cenários contemporâneos. Todavia, o desafiador cenário globalizado exige a precisão e a 
                   definição das regras de conduta normativas. """ ;
        final var expectedErrorMessage = "'name' must be between 3 and 255 characters ";
        final var expectedErrorCount = 1;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        final var actualCategory =
                Category.newCategory( blankName, expectedErrorMessage, expectedActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());

    }

    @Test
    public void givenAInvalidEmptyDescription_whenCallNewCategoryAndValidate_thenShouldReceiveError() {

        //criacao de teste baseado em TDD, garantindo que o métod0 seja implementado após o teste.

        final String expectedName = "Filmes";
        final var expectedDescription = " ";
        final var expectedActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedActive);

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));
        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    public void givenAValidActiveCategory_whenCallDeactivatr_thenReturnCategoryInactived(){

        final var expectedName = "Filmes" ;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = false;

        final var aCategory =
                Category.newCategory(expectedName, expectedDescription, true);

        final var updatedAt = aCategory.getUpdatedAt();

        Assertions.assertTrue(aCategory.isActive());
        Assertions.assertNotNull(aCategory.getUpdatedAt());

        final var actualCategory = aCategory.deactivate();

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));


        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNotNull(actualCategory.getDeletedAt());

    }

    @Test
    public void givenAValidInactiveCategory_whenCallActivate_thenReturnCategoryActived(){

        final var expectedName = "Filmes" ;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        final var aCategory =
                Category.newCategory(expectedName, expectedDescription, false);

        final var updatedAt = aCategory.getUpdatedAt();
        final var createdAt = aCategory.getCreatedAt();

        Assertions.assertFalse(aCategory.isActive());
        Assertions.assertNotNull(aCategory.getUpdatedAt());

        final var actualCategory = aCategory.activate();

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));


        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertEquals(createdAt, actualCategory.getCreatedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    public void givenAValidCategory_whenCallUpdate_thenReturnCategoryUpdated(){

        final var expectedName = "Filmes" ;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var aCategory =
                Category.newCategory("Filme", "A categoria", false);

        final var updatedAt = aCategory.getUpdatedAt();
        final var createdAt = aCategory.getCreatedAt();

        Assertions.assertFalse(aCategory.isActive());
        Assertions.assertNotNull(aCategory.getUpdatedAt());

        final var actualCategory = aCategory.update(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertEquals(createdAt, actualCategory.getCreatedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNull(actualCategory.getDeletedAt());

    }

    @Test
    public void givenAValidCategory_whenCallUpdateToInactive_thenReturnCategoryUpdated(){

        final var expectedName = "Filmes" ;
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = false;

        final var aCategory =
                Category.newCategory("Filme", "A categoria", true);

        final var updatedAt = aCategory.getUpdatedAt();
        final var createdAt = aCategory.getCreatedAt();


        Assertions.assertTrue(aCategory.isActive());
        Assertions.assertNotNull(aCategory.getUpdatedAt());


        final var actualCategory = aCategory.update(expectedName, expectedDescription, false);

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(aCategory.getId(), actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertFalse(aCategory.isActive());
        Assertions.assertNotNull(aCategory.getUpdatedAt());
        Assertions.assertEquals(createdAt, actualCategory.getCreatedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));

    }



}