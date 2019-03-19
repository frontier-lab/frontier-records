package com.frontier.records.api.comment.service;

import com.frontier.records.api.comment.mapper.CommentMapper;
import com.frontier.records.api.comment.model.Comment;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
