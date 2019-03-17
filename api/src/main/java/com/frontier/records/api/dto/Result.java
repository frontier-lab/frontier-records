package com.frontier.records.api.dto;

import lombok.Getter;

@SuppressWarnings("CheckStyle")
public class Result<Content> implements ResultType {

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
