package com.frontier.records.api.mapper;

import com.frontier.records.api.model.Music;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecommendMapper {

    List<Music> selectAllRecentMusics(@Param("startOffset") long startOffset, @Param("size") int size);

    int selectRecentMusicTotalCount();

    int selectRecentMusicCurrentCount(@Param("startOffset") long startOffset, @Param("size") int size);

    List<Music> selectAllWeeklyHotMusics(@Param("size") int size);
}
