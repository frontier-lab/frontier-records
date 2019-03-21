package com.frontier.records.api.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.ZonedDateTime;
import lombok.Data;

@SuppressWarnings("CheckStyle")
@Data
public class Comment {

    private Integer commentId;
    private Integer parentCommentId;
    private String comment;
    private Integer writerId;

    @JsonIgnore
    private Integer musicId;

    @JsonIgnore
    private Integer artistId;

    private String writerName;
    private String writerImage;
    private ZonedDateTime registerDateTime;
    private ZonedDateTime modifyDateTime;

    public static Comment createMusicComment(Integer musicId, Integer writerId, CommentWrite commentWrite) {
        Comment comment = new Comment();
        comment.setParentCommentId(commentWrite.getParentCommentId());
        comment.setComment(commentWrite.getComment());
        comment.setWriterId(writerId);
        comment.setMusicId(musicId);
        return comment;
    }

    public static Comment createArtistComment(Integer artistId, Integer writerId, CommentWrite commentWrite) {
        Comment comment = new Comment();
        comment.setParentCommentId(commentWrite.getParentCommentId());
        comment.setComment(commentWrite.getComment());
        comment.setWriterId(writerId);
        comment.setArtistId(artistId);
        return comment;
    }
}
