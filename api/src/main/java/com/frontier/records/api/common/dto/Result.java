package com.frontier.records.api.common.dto;

import lombok.Getter;

@SuppressWarnings("CheckStyle")
public class Result<Content> {

    public static final Result EMPTY = new Result<>(null);

    @Getter
    private final boolean successful;

    @Getter
    private final Content content;

    public Result(Content content) {
        this.successful = true;
        this.content = content;
    }

    public Result() {
        this.successful = false;
        this.content = null;
    }
}
