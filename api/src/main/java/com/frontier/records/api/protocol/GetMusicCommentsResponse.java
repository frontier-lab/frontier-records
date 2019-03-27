package com.frontier.records.api.protocol;

import com.frontier.records.api.dto.comment.CommentDto;
import com.frontier.records.api.util.pagination.Page;
import com.frontier.records.api.util.pagination.Pager;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
public class GetMusicCommentsResponse<T> extends Page<T> implements Serializable {

    private static final long serialVersionUID = 6579162379465735230L;

    private GetMusicCommentsResponse(Pager pager, int total, List<T> content) {
        super(pager, total, content);
    }

    public static GetMusicCommentsResponse create(Pager pager, int total, List<CommentDto> comments) {
        return new GetMusicCommentsResponse<>(pager, total, comments);
    }
}
