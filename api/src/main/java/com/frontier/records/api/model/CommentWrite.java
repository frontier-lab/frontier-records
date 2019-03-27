package com.frontier.records.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class CommentWrite {

    private Integer parentCommentId;

    @NonNull
    private String comment;
}
