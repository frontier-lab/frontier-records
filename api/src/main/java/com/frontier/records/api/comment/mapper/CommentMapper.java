package com.frontier.records.api.comment.mapper;

import com.frontier.records.api.comment.model.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentMapper {

    Comment selectMusicComment(@Param("commentId") Integer commentId);

    List<Comment> selectMusicComments(@Param("musicId") Integer musicId,
                                      @Param("startOffset") long startOffset,
                                      @Param("size") int size);

    long selectMusicCommentsTotalCount(@Param("musicId") Integer musicId);

    void insertComment(Comment comment);

    void deleteComment(@Param("commentId") Integer commentId);
}
