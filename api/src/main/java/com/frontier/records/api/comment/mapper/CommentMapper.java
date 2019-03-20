package com.frontier.records.api.comment.mapper;

import com.frontier.records.api.comment.model.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentMapper {
    
    List<Comment> selectMusicComments(@Param("musicId") Integer musicId,
                                      @Param("startOffset") long startOffset,
                                      @Param("size") int size);

    long selectMusicCommentsTotalCount(@Param("musicId") Integer musicId);
}
