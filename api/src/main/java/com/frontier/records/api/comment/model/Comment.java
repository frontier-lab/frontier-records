package com.frontier.records.api.comment.model;

import java.time.ZonedDateTime;
import lombok.Data;

@SuppressWarnings("CheckStyle")
@Data
public class Comment {

    private Integer commentId;
    private Integer parentCommentId;
    private String comment;
    private Integer writerId;
    private String writerName;
    private String writerImage;
    private ZonedDateTime registerDateTime;
    private ZonedDateTime modifyDateTime;
}
