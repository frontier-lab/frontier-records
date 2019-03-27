package com.frontier.records.api.util.pagination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

public class Pager {

    @Getter
    @Setter
    private int page;

    @Getter
    @Setter
    private int size;

    @ApiIgnore
    @JsonIgnore
    public int offset() {
        return this.page * this.size;
    }
}