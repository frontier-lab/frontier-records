package com.frontier.records.api.dto.comment;

import com.frontier.records.api.model.Comment;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
public class CommentDto implements Serializable {

    private static final long serialVersionUID = 8073348917143707479L;

    private Integer commentId;
    private Integer parentCommentId;
    private String content;
    private Integer writerId;
    private String writerName;
    private String writerImage;
    private ZonedDateTime registerDateTime;
    private ZonedDateTime modifyDateTime;


    public static CommentDto create(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.commentId = comment.getCommentId();
        commentDto.parentCommentId = comment.getParentCommentId();
        commentDto.content = comment.getContent();
        commentDto.writerId = comment.getWriterId();
        commentDto.writerName = comment.getWriterName();
        commentDto.writerImage = comment.getWriterImage();
        commentDto.registerDateTime = comment.getRegisterDateTime();
        commentDto.modifyDateTime = comment.getModifyDateTime();
        return commentDto;
    }
}
