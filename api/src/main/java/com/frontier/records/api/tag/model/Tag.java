package com.frontier.records.api.tag.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@SuppressWarnings("CheckStyle")
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Tag {

    private Integer tagId;
    private String tagName;
}
