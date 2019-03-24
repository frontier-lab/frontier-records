package com.frontier.records.api.common.dto;

import java.util.Collections;
import java.util.List;
import lombok.Getter;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@SuppressWarnings("CheckStyle")
public class PageResult<Content> extends PageImpl<Content> {

    @Getter
    private final boolean successful;

    public PageResult(List<Content> content, Pageable pageable, long totalCount) {
        super(content, pageable, totalCount);
        this.successful = true;
    }

    public PageResult() {
        super(Collections.emptyList());
        this.successful = false;
    }
}
