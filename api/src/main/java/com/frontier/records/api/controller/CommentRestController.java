package com.frontier.records.api.controller;

import com.frontier.records.api.protocol.ApiResponse;
import com.frontier.records.api.protocol.DeleteMusicCommentRequest;
import com.frontier.records.api.protocol.GetMusicCommentsRequest;
import com.frontier.records.api.protocol.GetMusicCommentsResponse;
import com.frontier.records.api.protocol.PostMusicCommentRequest;
import com.frontier.records.api.protocol.PostMusicCommentResponse;
import com.frontier.records.api.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 댓글 앱 API
 * Author : jaeeun.yoo
 */
@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    private static final int TEST_WRITER_ID = 1;

    @ApiOperation(value = "곡 댓글 조회", notes = "parentCommentId가 0이면 댓글, 그렇지 않으면 대댓글")
    @PostMapping("/getMusicComments")
    public ApiResponse<GetMusicCommentsResponse> getMusicComments(GetMusicCommentsRequest request) {
        return new ApiResponse<>(GetMusicCommentsResponse.create(request,
                                                                 commentService.getMusicCommentsTotalCount(request.getMusicId()),
                                                                 commentService.getMusicComments(request.getMusicId(), request)));
    }

    @ApiOperation(value = "곡 댓글 쓰기", notes = "parentCommentId가 0이면 댓글, 그렇지 않으면 대댓글")
    @PostMapping("/postMusicComment")
    public ApiResponse<PostMusicCommentResponse> setMusicComment(PostMusicCommentRequest request) {
        return new ApiResponse<>(PostMusicCommentResponse.create(commentService.postMusicComment(request.getMusicId(),
                                                                                                 TEST_WRITER_ID,
                                                                                                 request.getParentCommentId(),
                                                                                                 request.getContent())));
    }

    @ApiOperation(value = "댓글 삭제")
    @PostMapping("/deleteMusicComment")
    public ApiResponse deleteComment(DeleteMusicCommentRequest request) {
        commentService.deleteComment(request.getCommentId());
        return ApiResponse.EMPTY;
    }
}
