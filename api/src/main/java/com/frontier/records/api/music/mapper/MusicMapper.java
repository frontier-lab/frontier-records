package com.frontier.records.api.music.mapper;

import com.frontier.records.api.music.model.MusicDetail;
import com.frontier.records.api.music.model.MusicSummary;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MusicMapper {

    MusicDetail selectOneMusicDetail(@Param("musicId") Integer musicId);

    List<MusicSummary> selectMusicSummariesByTag(
        @Param("tagId") Integer tagId,
        @Param("startOffset") long offset,
        @Param("size") int pageSize);

    long getMusicSummaryTotalCountByTag(@Param("tagId") Integer tagId);

    void updateMusicPlayCount(@Param("musicId") Integer musicId);
}