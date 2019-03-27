package com.frontier.records.api.service;

import com.frontier.records.api.dto.comment.CommentDto;
import com.frontier.records.api.mapper.CommentMapper;
import com.frontier.records.api.model.Comment;
import com.frontier.records.api.util.pagination.Pager;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("CheckStyle")
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    public List<CommentDto> getMusicComments(Integer musicId, Pager pager) {
        return commentMapper.selectMusicComments(musicId, pager.offset(), pager.getSize())
                            .stream()
                            .map(CommentDto::create)
                            .collect(Collectors.toList());
    }

    public int getMusicCommentsTotalCount(Integer musicId) {
        return commentMapper.selectMusicCommentsTotalCount(musicId);
    }

    @Transactional
    public CommentDto postMusicComment(Integer musicId, Integer writerId, Integer parentCommentId, String content) {
        Comment comment = Comment.createMusicCommentFrom(musicId, writerId, parentCommentId, content);
        commentMapper.insertComment(comment);
        return CommentDto.create(commentMapper.selectMusicComment(comment.getCommentId()));
    }

    public void deleteComment(Integer commentId) {
        commentMapper.deleteComment(commentId);
    }
}
