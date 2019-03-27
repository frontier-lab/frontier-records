package com.frontier.records.api.mapper;

import com.frontier.records.api.model.Music;
import com.frontier.records.api.model.MusicSummary;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MusicMapper {

    Music selectOneMusicDetail(@Param("musicId") Integer musicId);

    List<MusicSummary> selectMusicSummariesByTag(
        @Param("tagId") Integer tagId,
        @Param("startOffset") long offset,
        @Param("size") int pageSize);

    int getMusicSummaryTotalCountByTag(@Param("tagId") Integer tagId);

    void updateMusicPlayCount(@Param("musicId") Integer musicId);

    void updateMusicViewCount(@Param("musicId") Integer musicId);
}