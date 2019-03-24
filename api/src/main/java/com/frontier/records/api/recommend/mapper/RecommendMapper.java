package com.frontier.records.api.recommend.mapper;

import com.frontier.records.api.recommend.model.RecommendMusic;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecommendMapper {

    List<RecommendMusic> selectAllRecentMusics(@Param("startOffset") long startOffset, @Param("size") int size);

    long selectRecentMusicTotalCount();
}
