package com.frontier.records.api.comment.service;

import com.frontier.records.api.comment.mapper.CommentMapper;
import com.frontier.records.api.comment.model.Comment;
import com.frontier.records.api.comment.model.CommentWrite;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("CheckStyle")
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    public List<Comment> getMusicComments(Integer musicId, Pageable pageable) {
        return commentMapper.selectMusicComments(musicId, pageable.getOffset(), pageable.getPageSize());
    }

    public long getMusicCommentsTotalCount(Integer musicId) {
        return commentMapper.selectMusicCommentsTotalCount(musicId);
    }

    @Transactional
    public Comment setMusicComment(Integer musicId, CommentWrite commentWrite) {
        //FIXME 인증 필터에서 받아올 예정
        Comment comment = Comment.createMusicComment(musicId, 1, commentWrite);
        commentMapper.insertComment(comment);
        return commentMapper.selectMusicComment(comment.getCommentId());
    }
}
