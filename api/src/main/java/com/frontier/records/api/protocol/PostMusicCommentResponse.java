package com.frontier.records.api.protocol;

import com.frontier.records.api.dto.comment.CommentDto;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostMusicCommentResponse implements Serializable {

    private static final long serialVersionUID = 3732896925751513123L;

    private CommentDto addedComment;

    public static PostMusicCommentResponse create(CommentDto addedComment) {
        return new PostMusicCommentResponse(addedComment);
    }
}
