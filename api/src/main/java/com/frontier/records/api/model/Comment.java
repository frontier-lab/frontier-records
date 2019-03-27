package com.frontier.records.api.model;

import java.time.ZonedDateTime;
import lombok.Data;

@SuppressWarnings("CheckStyle")
@Data
public class Comment {

    private Integer commentId;
    private Integer parentCommentId;
    private String content;
    private Integer writerId;
    private Integer musicId;
    private Integer artistId;
    private String writerName;
    private String writerImage;
    private ZonedDateTime registerDateTime;
    private ZonedDateTime modifyDateTime;

    public static Comment createMusicCommentFrom(Integer musicId, Integer writerId, Integer parentCommentId, String content) {
        Comment comment = new Comment();
        comment.setParentCommentId(parentCommentId);
        comment.setContent(content);
        comment.setWriterId(writerId);
        comment.setMusicId(musicId);
        return comment;
    }
}
