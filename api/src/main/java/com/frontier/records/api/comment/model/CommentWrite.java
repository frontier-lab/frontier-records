package com.frontier.records.api.comment.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class CommentWrite {

    private Integer commentId;

    private Integer parentCommentId;

    @NonNull
    private String comment;
}
