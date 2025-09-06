package com.fullcycle.admin.catalogo.domain.Category;

public record CategorySearchQuery(
        int page,
        int perPage,
        String terms,
        String sort,
        String direction
) {
}
