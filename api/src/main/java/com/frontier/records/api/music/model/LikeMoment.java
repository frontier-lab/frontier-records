package com.frontier.records.api.music.model;

import lombok.Data;

@SuppressWarnings("CheckStyle")
@Data
public class LikeMoment {

    private long moment;
    private int likeCount;
}
