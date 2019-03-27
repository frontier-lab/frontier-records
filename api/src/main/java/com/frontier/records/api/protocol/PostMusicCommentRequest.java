package com.frontier.records.api.protocol;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PostMusicCommentRequest {

    private Integer parentCommentId = 0;

    @NonNull
    private Integer musicId;

    @NonNull
    private String content;
}
