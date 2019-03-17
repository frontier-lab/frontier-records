package com.frontier.records.api.music.mapper;

import com.frontier.records.api.music.model.MusicDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MusicMapper {

    MusicDetail selectOneMusicDetail(@Param("musicId") Integer musicId);

//    int selectLikeMomentCountByMusicId(@Param("musicId") Integer musicId);

//    List<LikeMoment> selectAllLikeMomentsByMusicId(@Param("musicId") Integer musicId);
}