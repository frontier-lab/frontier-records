package com.frontier.records.api.aratst.model;

import java.time.ZonedDateTime;
import lombok.Data;
import lombok.Getter;

@SuppressWarnings("CheckStyle")
@Getter
@Data
public class Artist {

    private Integer artistId;
    private String artistName;
    private int likeCount;
    private ZonedDateTime registerDateTime;
    private ZonedDateTime modifyDateTime;
    private boolean deactivated;
    private boolean deleted;
}
