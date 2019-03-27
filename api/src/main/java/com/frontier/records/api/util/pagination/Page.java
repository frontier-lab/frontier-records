package com.frontier.records.api.util.pagination;

import java.util.List;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@Getter
@ToString
public class Page<T> {

    private final int numberOfElements;
    private final boolean hasMore;
    private final int page;
    private final int size;
    private final int totalElements;
    private final List<T> contents;

    public Page(Pager pager, int totalElements, List<T> contents) {
        this.numberOfElements = contents.size();
        this.hasMore = pager.offset() + this.numberOfElements < totalElements;
        this.page = pager.getPage();
        this.size = pager.getSize();
        this.totalElements = totalElements;
        this.contents = contents;
    }
}
