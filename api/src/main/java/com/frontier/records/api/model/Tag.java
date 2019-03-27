package com.frontier.records.api.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class Tag implements Serializable {

    private static final long serialVersionUID = -1L;

    private Integer tagId;
    private String tagName;
    private boolean deleted;
    private ZonedDateTime registerDateTime;
    private ZonedDateTime modifyDateTime;
}
