package com.springboot.beerservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPagedList extends PageImpl<BeerDto> {

    /**
     * Constructor of {@code PageImpl}.
     *
     * @param content  the content of this page, must not be {@literal null}.
     * @param pageable the paging information, must not be {@literal null}.
     * @param total    the total amount of items available. The total might be adapted considering the length of the content
     */
    public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    /**
     * Creates a new {@link PageImpl} with the given content. This will result in the created  being identical
     * to the entire {@link List}.
     *
     * @param content must not be {@literal null}.
     */
    public BeerPagedList(List<BeerDto> content) {
        super(content);
    }
}
