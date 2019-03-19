package com.frontier.records.api.music.service;

import com.frontier.records.api.music.mapper.MusicMapper;
import com.frontier.records.api.music.model.MusicDetail;
import com.frontier.records.api.music.model.MusicSummary;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicMapper musicMapper;

    public MusicDetail getMusicDetail(Integer musicId) {
        return musicMapper.selectOneMusicDetail(musicId);
    }

    public List<MusicSummary> getMusicSummariesByTag(Integer tagId, Pageable pageable) {
        return musicMapper.selectMusicSummariesByTag(tagId, pageable.getOffset(), pageable.getPageSize());
    }

    public long getMusicSummaryTotalCountByTag(Integer tagId) {
        return musicMapper.getMusicSummaryTotalCountByTag(tagId);
    }
}
