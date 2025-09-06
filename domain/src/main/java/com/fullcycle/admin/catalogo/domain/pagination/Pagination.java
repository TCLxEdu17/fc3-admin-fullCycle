package com.fullcycle.admin.catalogo.domain.pagination;

import java.util.List;

public record Pagination<T>(
        int currrentPage,
        int perPage,
        Long total,
        List<T> items
) {

}
