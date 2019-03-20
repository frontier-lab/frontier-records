package com.frontier.records.api.comment;

import com.frontier.records.api.comment.model.Comment;
import com.frontier.records.api.comment.service.CommentService;
import com.frontier.records.api.dto.PageResult;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    @ApiOperation(value = "곡 댓글 조회", notes = "parentCommentId가 null이면 댓글, 그렇지 않으면 대댓글")
    @GetMapping("/music/{musicId}")
    public PageResult<Comment> getMusicComments(@PathVariable Integer musicId, Pageable pageable) {
        return new PageResult<>(commentService.getMusicComments(musicId, pageable),
                                pageable,
                                commentService.getMusicCommentsTotalCount(musicId));
    }
}
