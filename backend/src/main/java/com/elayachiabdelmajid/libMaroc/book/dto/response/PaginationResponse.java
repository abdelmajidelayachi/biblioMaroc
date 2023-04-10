package com.elayachiabdelmajid.libMaroc.book.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class PaginationResponse<T> {

    private List<T> content;
    private int totalPages;
    private long totalElements;
    private int size;
    private int numberOfElements;

    public PaginationResponse(int totalPages, List<T> content, long totalElements, int size, int numberOfElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.numberOfElements = numberOfElements;
    }


}
